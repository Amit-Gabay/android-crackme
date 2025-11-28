1. At first, the app crashes when trying to open it - looked for the cause in the logs using `adb logcat \*:E` ( '\*:E' to filter on error messages only)

2. I saw it was related to something with libbinder after fork() blablabla.. Tried to downgrade android version (to a pretty old one) and it worked! The app successfuly opened.

3. I saw inside `CodeCheck` there is a function checking whether the password is valid or not by calling some `native` function named `bar`.
It turns out `native` means it's a `C/C++` code in an `.so`.

4. I disassembled the `libfoo.so` and found inside that it compares the textbox input to `Thanks for all the fish`, and it worked - that's the password.