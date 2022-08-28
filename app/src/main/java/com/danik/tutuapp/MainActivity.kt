package com.danik.tutuapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.danik.tutuapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    /*  private lateinit var navHostController: NavHostController
      private lateinit var worker: WorkManager*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate")


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewModel by viewModels<ListViewViewModel>()

        val items = viewModel.trains
        val trainAdapter = TrainAdapter()

        binding.bindAdapter(trainAdapter = trainAdapter)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                items.collectLatest {
                    trainAdapter.submitData(it)
                }
            }
        }*/


    }
}

/*private fun ActivityMainBinding.bindAdapter(trainAdapter: TrainAdapter) {
    list.adapter = trainAdapter
    list.layoutManager = LinearLayoutManager(list.context)
    val decoration = DividerItemDecoration(list.context, DividerItemDecoration.VERTICAL)
    list.addItemDecoration(decoration)
}*/
/* setContent {
     TuTuAppTheme {
         navHostController = rememberNavController()
         SetupNavigation(navController = navHostController)
         worker = WorkManager.getInstance(applicationContext)
         val textInput = remember { mutableStateOf("") }
         val periodicWork =
             PeriodicWorkRequestBuilder<DownloadTrainsWorker>(5, TimeUnit.SECONDS)
                 .setConstraints(
                     Constraints.Builder()
                         //.setRequiredNetworkType(NetworkType.UNMETERED)
                         //.setRequiresBatteryNotLow(true)
                         //.setRequiresCharging(true)
                         //.setRequiresDeviceIdle(true)
                         .build()
                 ).build()
         worker.enqueueUniquePeriodicWork(
             "train_loader",
             ExistingPeriodicWorkPolicy.KEEP,
             periodicWork
         )

         worker.getWorkInfoByIdLiveData(periodicWork.id).observe(this, Observer { workInfo ->
             workInfo.let {
                 if (it.state.isFinished) {
                     val outputData = it.outputData
                     val taskResult = outputData.getString(DownloadTrainsWorker.WORK_RESULT)
                     if (taskResult != null) {
                         textInput.value = taskResult
                     }
                 } else {
                     val workStatus = workInfo.state
                     textInput.value = workStatus.toString()
                 }
             }
         })
     LaunchedEffect(key1 = true){
         worker.enqueue(periodicWork)
     }
     }
 }
}
companion object {
 const val MESSAGE_STATUS = "message_status"
}*/


