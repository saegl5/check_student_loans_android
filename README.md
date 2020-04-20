![Alt](./app_icon_and_logo.png "Check Student Loans")

## Native App

Check your student loan's length of repayment and amount of savings.

This project is a native Android app that is one of two parts of an experimental study&mdash;the other part being [course material](https://gitlab.com/check-student-loans/course-material "Click here to locate the course material."), and it is designed to supplement the course material.
The combination of both parts is dubbed an *instructional app*. Users select an estimated cost, select the interest rate of their loan, and select a monthly payment. 
The app will estimate how long repayments will take and how much users can save by paying more than the minimum.
(This app will not tell you how much money you have loaned. Contact your school's bursar office for that information. Once you have that information, use this app.)

Features:
* Automatic estimation
* Swipe leftward to view how estimates were calculated.

Designed for phones running Android 4.2 (Jelly Bean) or above

Alternative downloads: \
[Version 1.x Alpha for Formal Field Test](https://gitlab.com/check-student-loans/android/-/blob/d447615b5e24d029a76c61be913c106010c5fde0/Archives/formal_field_test.apk "Click here to access the download link.")* &nbsp;:white_check_mark:[[No malware detected](https://www.virustotal.com/gui/file/c390f6a054cfb699fcc209f671a7ff8df6d2df9d7145642dfa1663c890f07b99/detection)] \
[Version 1.x Alpha for Informal Field Test](https://gitlab.com/check-student-loans/android/-/blob/d447615b5e24d029a76c61be913c106010c5fde0/Archives/informal_field_test.apk "Click here to access the download link.")*^ &nbsp;:white_check_mark:[[No malware detected](https://www.virustotal.com/gui/file/70246579afcb5b944812d34e2b821939a692692a413e5346fcbd5eb9319078fc/detection)] \
[Version 1.x Alpha for Focus Groups](https://gitlab.com/check-student-loans/android/-/blob/d447615b5e24d029a76c61be913c106010c5fde0/Archives/focus_groups.apk "Click here to access the download link.")^ &nbsp;:white_check_mark:[[No malware detected](https://www.virustotal.com/gui/file/70246579afcb5b944812d34e2b821939a692692a413e5346fcbd5eb9319078fc/detection)] \
[Version 1.x Alpha - Final](https://gitlab.com/check-student-loans/android/-/blob/d447615b5e24d029a76c61be913c106010c5fde0/Archives/final.apk "Click here to access the download link.") &nbsp;:white_check_mark:[[No malware detected](https://www.virustotal.com/gui/file/47a7d6b6a3ab33e5b5a5dd2cbc278d3dc22ef72717fe29638e9de7a33ef44a97/details)]

\* renamed
\^ identical

Install alternative downloads directly on phones running Android 4.2 (Jelly Bean) or above.


## Build from Source Code

Download [Android Studio](https://developer.android.com/studio/ "Click here to access the download link.") from Google, and install it. \
(For help with installing the application, follow its [installation instructions](https://developer.android.com/studio/install "Click here to access the instructions.").)

Do not run Android Studio in a virtual machine, though. Run it in a user's host operating system. \
Otherwise, the app may not run successfully or quickly in an Android Virtual Device.

Also, download and install [Git](https://git-scm.com/downloads "Click here to access the download link.").

Open a terminal, and clone the project:
```
git clone https://gitlab.com/check-student-loans/android.git
```

(Recommended) Verify the project's authenticity: Look upward for "Verified," next to the commit SHA.

(Recommended) Open a terminal, and verify the project's integrity:
```
cd android
git show-ref --heads --hash
```
Check that the hash matches the commit SHA.

Open the project in Android Studio, and build the native app:
* For a virtual or connected Android phone, select Build > Make Project.
* Otherwise, select Build > Build APK(s).

## Usage

Run the native app in a virtual device (e.g., Galaxy Nexus with API 28 x86) or on a connected device. \
Or, install the APK file directly on a user's own Android phone.

Move the thumb of the slider, to select an estimated cost nearest to yours. \
Press &#x25BC; to select the [interest rate](https://studentaid.ed.gov/sa/types/loans/interest-rates "Click here to visit the office of Federal Student Aid.") of your loan. \
Press &minus; or &#43; to select a monthly payment nearest to yours.

Known to work in Android Studio 3.4.2 and phones running Android 4.2 (Jelly Bean) or above.

## Contributing

This project has been archived. \
Please contribute to the project's counterpart, which is based on iOS, by going [here](https://gitlab.com/check-student-loans/ios "Click here to access the most recent iOS build.").

## History

Oct 31, 2019: enhanced accessibility \
Sep 25, 2019: unified author name and email of all commits \
Sep 17, 2019: starting signing commits, signed and re-committed old ones, inadvertently lost empty commits but they were empty anyway \
Oct 12, 2018: refreshed entire project but inadvertently purged commit history \
Sep 26, 2018 &middot; Version 1.x: initial commit

## Known Issues

This native app is an alpha build that is outdated. \
Access the native app's most recent build, which is based on iOS, [here](https://gitlab.com/check-student-loans/ios "Click here to access the most recent build.").

## License

MIT

Copyright (c) 2018-2020 Ed Silkworth