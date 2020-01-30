<snippet>
<content>
 
# ![Alt](./app_icon_and_logo.png "Check Student Loans")

Check your student loan's length of repayment and amount of savings.<p>

This project is a native Android app that is one of two parts of an experimental study&mdash;the other part being [course material](https://gitlab.com/check-student-loans/course-material "Click here to locate the course material."), and it is designed to supplement the course material.
The combination of both parts is dubbed an *instructional app*. Users select an estimated cost, select the interest rate of their loan, and select a monthly payment. 
The app will estimate how long repayments will take and how much users can save by paying more than the minimum.
(This app will not tell you how much money you have loaned. Contact your school's bursar office for that information. Once you have that information, use this app.)<p>

Features:
* Automatic estimation
* Swipe leftward to view how estimates were calculated.

Designed for phones running Android 4.2 (Jelly Bean) or above<p>

Alternative downloads:<br>
[Version 1.x Alpha for Formal Pilot Test](./Archives/formal_pilot_test.apk "Click here to access the download link.") &nbsp; <img src="https://gitlab.com/gitlab-org/gitlab-foss/raw/master/app/assets/images/emoji/white_check_mark.png" width="16px" height="16px" style="display:inline;margin:0" aria-hidden="true"> </i> [[No malware detected](https://www.virustotal.com/gui/file/c390f6a054cfb699fcc209f671a7ff8df6d2df9d7145642dfa1663c890f07b99/detection)]<br>
[Version 1.x Alpha for Informal Pilot Test](./Archives/informal_pilot_test.apk "Click here to access the download link.")* &nbsp; <img src="https://gitlab.com/gitlab-org/gitlab-foss/raw/master/app/assets/images/emoji/white_check_mark.png" width="16px" height="16px" style="display:inline;margin:0" aria-hidden="true"> </i> [[No malware detected](https://www.virustotal.com/gui/file/70246579afcb5b944812d34e2b821939a692692a413e5346fcbd5eb9319078fc/detection)]<br>
[Version 1.x Alpha for Focus Groups](./Archives/focus_groups.apk "Click here to access the download link.")* &nbsp; <img src="https://gitlab.com/gitlab-org/gitlab-foss/raw/master/app/assets/images/emoji/white_check_mark.png" width="16px" height="16px" style="display:inline;margin:0" aria-hidden="true"> </i> [[No malware detected](https://www.virustotal.com/gui/file/70246579afcb5b944812d34e2b821939a692692a413e5346fcbd5eb9319078fc/detection)]<br>
[Version 1.x Alpha - Final](./Archives/final.apk "Click here to access the download link.") &nbsp; <img src="https://gitlab.com/gitlab-org/gitlab-foss/raw/master/app/assets/images/emoji/white_check_mark.png" width="16px" height="16px" style="display:inline;margin:0" aria-hidden="true"> </i> [[No malware detected](https://www.virustotal.com/gui/file/47a7d6b6a3ab33e5b5a5dd2cbc278d3dc22ef72717fe29638e9de7a33ef44a97/details)]<p>

\* identical

Install alternative downloads directly on phones running Android 4.2 (Jelly Bean) or above.


## Build from Source Code

Download [Android Studio](https://developer.android.com/studio/ "Click here to access the download link.") from Google, and install it.<br>
(For help with installing the application, follow its [installation instructions](https://developer.android.com/studio/install "Click here to access the instructions.").)<p>

Do not run Android Studio in a virtual machine, though. Run it in a user's host operating system.<br>
Otherwise, the app may not run successfully or quickly in an Android Virtual Device.<p>

Also, download and install [Git](https://git-scm.com/downloads "Click here to access the download link.").

Open a terminal, and clone the project:
<pre>
git clone https://gitlab.com/check-student-loans/android.git
</pre>

(Recommended) Verify the project's authenticity: Look upward for "Verified" next to the commit SHA (e.g., Verified e733a45d).

(Recommended) Open a terminal, and verify the project's integrity:
<pre>
cd android
git show-ref --heads --hash
</pre>
Check that the hash matches the commit SHA.<p>

Open the project in Android Studio, and build the native app:<br>
* For a virtual or connected Android phone, select Build > Make Project.<br>
* Otherwise, select Build > Build APK(s).<p>

## Usage

Run the native app in a virtual device (e.g., Galaxy Nexus with API 28 x86) or on a connected device.<br>
Or, install the APK file directly on a user's own Android phone.<p>

Move the thumb of the slider, to select an estimated cost nearest to yours.<br>
Press &#x25BC; to select the [interest rate](https://studentaid.ed.gov/sa/types/loans/interest-rates "Click here to visit the office of Federal Student Aid.") of your loan.<br>
Press &minus; or &#43; to select a monthly payment nearest to yours.<p>

Known to work in Android Studio 3.4.2 and phones running Android 4.2 (Jelly Bean) or above.

## Contributing

This project has been archived.<br>
Please contribute to the project's counterpart, which is based on iOS, by going [here](https://gitlab.com/check-student-loans/ios "Click here to access the most recent iOS build.").<p>

## History

Oct 31, 2019: enhanced accessibility<br>
Sep 25, 2019: unified author name and email of all commits<br>
Sep 17, 2019: starting signing commits, signed and re-committed old ones, inadvertently lost empty commits but they were empty anyway<br>
Oct 12, 2018: refreshed entire project but inadvertently purged commit history<br>
Sep 26, 2018 &middot; Version 1.x: initial commit

## Known Issues

This native app is an alpha build that is outdated.<br>
Access the native app's most recent build, which is based on iOS, [here](https://gitlab.com/check-student-loans/ios "Click here to access the most recent build.").<p>


## License

MIT

Copyright (c) 2018-2020 Ed Silkworth

</content>
</snippet>
