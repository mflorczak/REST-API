call runcrud
if "%ERRORLEVEL%" == "0" goto runchrome
echo Fail open runcrud
goto fail

:runchrome
start chrome http://localhost:8080/crud/v1/task/getTasks

:fail
echo.
echo There were errors