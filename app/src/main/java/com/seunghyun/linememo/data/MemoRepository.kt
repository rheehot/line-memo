package com.seunghyun.linememo.data

class MemoRepository(private val memoDao: MemoDao) {
    suspend fun insert(memo: Memo) = memoDao.insert(memo)
    suspend fun getAllMemos() = memoDao.loadAll()
    suspend fun update(memo: Memo) = memoDao.update(memo)
    suspend fun delete(memo: Memo) = memoDao.delete(memo)
}