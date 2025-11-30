1. First, used `gradlew` to compile the APK sources into a final `.apk` file.
2. Then, I saw the `.apk` is unsigned, read about signing keys and it turns out that I can use any signing keys I want as long as I do not modify and existing app!
3. After signing & installing the `.apk` I got an error message "Rooting or tampering detected".
4. Fixed this error by analyzing the CRC check, and patching the anticipated CRC values (which were just hardcoded in `strings.xml` and `foo.cpp`...).
5. Now the application runs!
6. Now it asked for password, which was at first not clear, after diving to `foo.cpp` to understand to which password it compares, it turns out it compares to a random password :O
7. Thus, I've decided to easily patch `foo.cpp` to pass any given password instead, and bypassed the mechanism (after re-correcting the CRCs again after the patch).
8. It worked