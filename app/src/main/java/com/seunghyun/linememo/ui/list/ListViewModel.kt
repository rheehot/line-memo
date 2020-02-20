package com.seunghyun.linememo.ui.list

import android.content.Intent
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seunghyun.linememo.data.Memo
import com.seunghyun.linememo.data.MemoRepository
import com.seunghyun.linememo.ui.edit.EditActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(private val repository: MemoRepository) : ViewModel() {
    val memos = MutableLiveData(arrayListOf<Memo>())

    init {
        updateAllMemos()
    }

    private fun updateAllMemos() = viewModelScope.launch(Dispatchers.Main) {
        val memoList = ArrayList(repository.getAllMemos().reversed())
        memos.postValue(memoList)
    }

    fun onAddButtonClick(view: View) {
        val context = view.context
        context.startActivity(Intent(context, EditActivity::class.java))
    }
}