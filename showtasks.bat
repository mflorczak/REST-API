call runcrud
if "%ERRORLEVEL%" == "0" goto runchrome
echo Fail open runcrud

:runchrome
start chrome hirku