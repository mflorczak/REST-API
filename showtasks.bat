call runcrud
if "%ERRORLEVEL%" == "0" goto runchrome
echo Fail open runcrud

:runchrome
start chrome http://localhost:8080/crud/v1/task/getTasks