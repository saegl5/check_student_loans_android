<snippet>
<content>
 
# ![Alt](/app_icon_and_logo.png "Check Student Loans")

Check your student loan's length of repayment and amount of savings.<p>

This project is a native Android app that is one of two parts of an experimental study&mdash;the other part being course material, and it is designed to supplement the course material.
The combination of both parts is dubbed an *instructional app*. Users select an estimated cost, select the interest rate of their loan, and select a monthly payment. 
The app will estimate how long repayments will take and how much users can save by paying more than the minimum.
(This app will not tell you how much money you have loaned. Contact your school's bursar office for that information. Once you have that information, use this app.)<p>

Features:
* Automatic estimation
* Swipe leftward to view how estimates were calculated

Designed for phones running Android 4.2 (Jelly Bean) or above.<p>

Alternative downloads:<br>
[Version 1.x for Formal Pilot Study](/Archives/formal_pilot_study.apk "Click here to access the download link.")<br>
[Version 1.x for Informal Pilot Study](/Archives/informal_pilot_study.apk "Click here to access the download link.")<br>
[Version 1.x for Focus Groups](/Archives/focus_groups.apk "Click here to access the download link.")<p>

Install alternative downloads directly on phones running Android 4.2 (Jelly Bean) or above.


## Build from Source Code

Download [Android Studio](https://developer.android.com/studio/ "Click here to access the download link.") from Google, and install it.<br>
(For help installing the application, follow its [installation instructions](https://developer.android.com/studio/install "Click here to access the instructions.").)<p>

Clone the project:
<pre>
https://gitlab.com/saegl5/check_student_loans_app_android.git
</pre>

(Recommended) Open a terminal application, and verify the project's integrity:
<pre>
$ cd /path/to/check_student_loans_app_android
$ git show-ref --heads --hash
</pre>
Check that the hash matches the commit SHA.<p>

Final version is 1.x. Known to work on Ubuntu 18.04.1 LTS (Linux 4.15.0-34-generic), in Android Studio 3.1.4 (AI-173.4907809) with JRE<sup>TM</sup> 8u152 64-Bit (1.8.0_152-release-1024-b01 amd64).


## Usage

Run the native app with either a virtual device (e.g., Galaxy Nexus with API 28 x86) or a user's own Android phone.<p>

Move the thumb of the slider, to select an estimated cost nearest to yours.<br>
Press &#x25BC; to select the interest rate of your loan.[^1]<br>
Press &minus; or &#43; to select a monthly payment nearest to yours.<p>

## Contributing

This project has been archived.<br>
Please contribute to the project's counterpart, which is based on iOS, by going [here](https://gitlab.com/saegl5/check_student_loans_app_ios "Click here to access the most recent iOS build.").<p>

## History

Sep 26, 2018 &middot; Version 1.x: initial commit

## Known Issues

This native app is an alpha build that is outdated.<br>
Access the native app's most recent build, which is based on iOS, [here](https://gitlab.com/saegl5/check_student_loans_app_ios "Click here to access the most recent build.").<p>


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

[^1]: Interest Rates and Fees. (n.d.). Retrieved from [https://studentaid.ed.gov/sa/types/loans/interest-rates](https://studentaid.ed.gov/sa/types/loans/interest-rates "Click here to visit the office of Federal Student Aid.")


</content>
</snippet>
