@echo off

echo Checking for new commits in the remote repository...

git fetch origin

echo Comparing local branch with remote branch...

git diff HEAD origin/main
@REM timeout /t 400
pause

@REM set repo=TravelEase
@REM set user=TayebsouiniYcode

@REM REM Get latest commit from repo
@REM for /f "tokens=*" %%i in ('curl -s https://api.github.com/repos/%user%/%repo%/commits/HEAD') do set latest=%%i

@REM REM Get latest commit from local repo
@REM for /f "tokens=*" %%i in ('git rev-parse HEAD') do set local=%%i

@REM REM Compare the two and check if there is a new push
@REM if "%local%"=="%latest%" (
@REM   echo No new push
@REM ) else (
@REM   echo New push detected!
@REM )

