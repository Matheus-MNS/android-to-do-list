package com.example.todolist.common.utils

typealias AdapterItemClickListener = () -> Unit
typealias AdapterItemWithParameterClickListener<T> = (T) -> Unit