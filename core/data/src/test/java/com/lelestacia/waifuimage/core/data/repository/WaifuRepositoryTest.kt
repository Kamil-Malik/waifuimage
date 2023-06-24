package com.lelestacia.waifuimage.core.data.repository

import com.lelestacia.waifuimage.core.common.Resource
import com.lelestacia.waifuimage.core.data.ErrorParserUtil
import com.lelestacia.waifuimage.core.remote.source.IWaifuDataSource
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import java.net.UnknownHostException
import com.lelestacia.waifuimage.core.data.R
import com.lelestacia.waifuimage.core.model.WaifuImage
import org.junit.Assert

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class WaifuRepositoryTest {

    @get:Rule
    val mockKRule = MockKRule(this)

    private val context = RuntimeEnvironment.getApplication().applicationContext

    @MockK
    lateinit var apiService: IWaifuDataSource

    @MockK
    lateinit var errorParserUtil: ErrorParserUtil

    private lateinit var repository: IWaifuRepository

    @Before
    fun setUp() {
        repository = WaifuRepository(
            apiService = apiService,
            errorParserUtil = errorParserUtil
        )
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `Exception should be handled properly`() = runTest {
        val throwable = UnknownHostException()
        coEvery { apiService.getWaifuImages() } throws throwable
        coEvery { errorParserUtil(throwable) } answers { context.getString(R.string.no_internet_connection) }
        val actualResult = repository.getWaifuImages().toList()
        coVerify(exactly = 1) { apiService.getWaifuImages() }
        coVerify(exactly = 1) { errorParserUtil(throwable) }
        Assert.assertTrue(
            "First result should be Loading",
            actualResult.first() is Resource.Loading
        )
        Assert.assertTrue(
            "Second and last result should be Error",
            actualResult.last() is Resource.Error
        )
        Assert.assertEquals("There should be only 2 result", actualResult.size, 2)
        Assert.assertEquals(
            "Second result error message should match",
            actualResult.last().message,
            context.getString(R.string.no_internet_connection)
        )
    }

    @Test
    fun `Result should be success and error parser should not be called`() = runTest {
        coEvery { apiService.getWaifuImages() } answers { emptyList() }
        val actualResult = repository.getWaifuImages().toList()
        coVerify(exactly = 1) { apiService.getWaifuImages() }
        coVerify(exactly = 0) { errorParserUtil(Exception()) }
        Assert.assertTrue(
            "First result should be Loading",
            actualResult.first() is Resource.Loading
        )
        Assert.assertTrue(
            "Second and last result should be Success",
            actualResult.last() is Resource.Success
        )
        Assert.assertEquals("There should be only 2 result", actualResult.size, 2)
        Assert.assertEquals(
            "Data from function should match the expected",
            actualResult.last().data,
            emptyList<WaifuImage>()
        )
    }
}