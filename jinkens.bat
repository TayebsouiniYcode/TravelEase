@echo off

set repo=TravelEase
set user=TayebsouiniYcode

REM Get latest commit from repo
for /f "tokens=*" %%i in ('curl -s https://api.github.com/repos/%user%/%repo%/commits/HEAD') do set latest=%%i

REM Get latest commit from local repo
for /f "tokens=*" %%i in ('git rev-parse HEAD') do set local=%%i

REM Compare the two and check if there is a new push
if "%local%"=="%latest%" (
  echo No new push
) else (
  echo New push detected!
)

timeout /t 400