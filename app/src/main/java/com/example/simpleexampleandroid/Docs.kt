package com.example.simpleexampleandroid

/** Coroutine tương tự như luồng nhưng nghẹ hơn -> nên được gọi [dòng]. Và có chức năng như luồng: Chạy song song và đợi nhau để giao tiếp.
 * Nhưng nó được sinh ra là để triển khai những thứ đơn giản và tiêu tốn nhẹ hơn rất nhiều so với Threads và có thể tạo nhiều mà k ảnh hường đến hiệu năng.
 *
 * Kiểu nó đợi nhau rồi chạy, có nghĩa 1 người trong team bị delay 1000s thì cả team cùng delay 1000s :3
 *
 * */