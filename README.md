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
[Version 1.x for Formal Pilot Test](./Archives/formal_pilot_test.apk "Click here to access the download link.") &#x2714;<br>
[Version 1.x for Informal Pilot Test](./Archives/informal_pilot_test.apk "Click here to access the download link.")<br>
[Version 1.x for Focus Groups](./Archives/focus_groups.apk "Click here to access the download link.")<p>

Install alternative downloads directly on phones running Android 4.2 (Jelly Bean) or above.


## Build from Source Code

Download [Android Studio](https://developer.android.com/studio/ "Click here to access the download link.") from Google, and install it.<br>
(For help with installing the application, follow its [installation instructions](https://developer.android.com/studio/install "Click here to access the instructions.").)<p>

Do not run Android Studio in a virtual machine, though. Run it in a user's host operating system.<br>
Otherwise, the app may not run successfully or quickly in an Android Virtual Device.<p>

Clone the project:
<pre>
$ git clone https://gitlab.com/check-student-loans/android.git
</pre>

(Recommended) Verify the project's authenticity: Look for "Verified" next to the commit SHA (e.g., Verified e733a45d).

(Recommended) Open GNOME Terminal (or similar), and verify the project's integrity:
<pre>
$ cd /path/to/android
$ git show-ref --heads --hash
</pre>
Check that the hash matches the commit SHA.<p>

The final version is 1.x. Known to work on Ubuntu 18.04 LTS (Linux 4.15.0-46-generic kernel), in Android Studio 3.3.1 (Build #AI-182.5107.16.33.5264788) with JRE 8u152 64-Bit (1.8.0_152-release-1248-b01 amd64)

## Usage

Run the native app with either a virtual device (e.g., Galaxy Nexus with API 28 x86) or a user's own Android phone.<p>

Move the thumb of the slider, to select an estimated cost nearest to yours.<br>
Press &#x25BC; to select the [interest rate](https://studentaid.ed.gov/sa/types/loans/interest-rates "Click here to visit the office of Federal Student Aid.") of your loan.<br>
Press &minus; or &#43; to select a monthly payment nearest to yours.<p>

## Contributing

This project has been archived.<br>
Please contribute to the project's counterpart, which is based on iOS, by going [here](https://gitlab.com/check-student-loans/ios "Click here to access the most recent iOS build.").<p>

## History

Sep 25, 2019: unified author name and email of all commits<br>
Sep 17, 2019: starting signing commits, signed and re-committed old ones, inadvertently lost empty commits but they were empty anyway<br>
Oct 12, 2018: refreshed entire project but inadvertently purged commit history<br>
Sep 26, 2018 &middot; Version 1.x: initial commit

## Known Issues

This native app is an alpha build that is outdated.<br>
Access the native app's most recent build, which is based on iOS, [here](https://gitlab.com/check-student-loans/ios "Click here to access the most recent build.").<p>


## License

MIT License

Copyright (c) 2018-2019 Ed Silkworth

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

</content>
</snippet>
