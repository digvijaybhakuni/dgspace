@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  jaxrx-demo startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Add default JVM options here. You can also use JAVA_OPTS and JAXRX_DEMO_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\jaxrx-demo-1.0.jar;%APP_HOME%\lib\jersey-container-servlet-2.25.jar;%APP_HOME%\lib\jersey-media-sse-2.25.jar;%APP_HOME%\lib\jersey-cdi1x-2.21.jar;%APP_HOME%\lib\jersey-media-json-jackson-2.21.jar;%APP_HOME%\lib\jersey-bean-validation-2.21.jar;%APP_HOME%\lib\undertow-core-1.4.7.Final.jar;%APP_HOME%\lib\undertow-servlet-1.4.7.Final.jar;%APP_HOME%\lib\weld-core-2.2.14.Final.jar;%APP_HOME%\lib\weld-servlet-core-2.2.14.Final.jar;%APP_HOME%\lib\javax.servlet-api-3.1.0.jar;%APP_HOME%\lib\jersey-common-2.25.jar;%APP_HOME%\lib\javax.ws.rs-api-2.0.1.jar;%APP_HOME%\lib\javax.inject-2.5.0-b30.jar;%APP_HOME%\lib\jersey-entity-filtering-2.21.jar;%APP_HOME%\lib\jackson-jaxrs-base-2.5.4.jar;%APP_HOME%\lib\jackson-jaxrs-json-provider-2.5.4.jar;%APP_HOME%\lib\jackson-annotations-2.5.4.jar;%APP_HOME%\lib\validation-api-1.1.0.Final.jar;%APP_HOME%\lib\hibernate-validator-5.1.3.Final.jar;%APP_HOME%\lib\javax.el-api-2.2.4.jar;%APP_HOME%\lib\javax.el-2.2.4.jar;%APP_HOME%\lib\jboss-logging-3.2.1.Final.jar;%APP_HOME%\lib\xnio-api-3.3.6.Final.jar;%APP_HOME%\lib\xnio-nio-3.3.6.Final.jar;%APP_HOME%\lib\jboss-servlet-api_3.1_spec-1.0.0.Final.jar;%APP_HOME%\lib\jboss-annotations-api_1.2_spec-1.0.0.Final.jar;%APP_HOME%\lib\cdi-api-1.2.jar;%APP_HOME%\lib\javax.inject-1.jar;%APP_HOME%\lib\weld-api-2.2.SP4.jar;%APP_HOME%\lib\weld-spi-2.2.SP4.jar;%APP_HOME%\lib\jboss-classfilewriter-1.0.5.Final.jar;%APP_HOME%\lib\guava-13.0.1.jar;%APP_HOME%\lib\jboss-el-api_3.0_spec-1.0.0.Alpha1.jar;%APP_HOME%\lib\jboss-interceptors-api_1.2_spec-1.0.0.Alpha3.jar;%APP_HOME%\lib\weld-environment-common-2.2.14.Final.jar;%APP_HOME%\lib\jackson-core-2.5.4.jar;%APP_HOME%\lib\jackson-databind-2.5.4.jar;%APP_HOME%\lib\jackson-module-jaxb-annotations-2.5.4.jar;%APP_HOME%\lib\classmate-1.0.0.jar;%APP_HOME%\lib\weld-core-impl-2.2.14.Final.jar;%APP_HOME%\lib\jersey-container-servlet-core-2.25.jar;%APP_HOME%\lib\jersey-server-2.25.jar;%APP_HOME%\lib\jersey-client-2.25.jar;%APP_HOME%\lib\jersey-media-jaxb-2.25.jar;%APP_HOME%\lib\javax.annotation-api-1.2.jar;%APP_HOME%\lib\hk2-api-2.5.0-b30.jar;%APP_HOME%\lib\hk2-locator-2.5.0-b30.jar;%APP_HOME%\lib\osgi-resource-locator-1.0.1.jar;%APP_HOME%\lib\hk2-utils-2.5.0-b30.jar;%APP_HOME%\lib\aopalliance-repackaged-2.5.0-b30.jar;%APP_HOME%\lib\javassist-3.20.0-GA.jar;%APP_HOME%\lib\jersey-guava-2.25.jar

@rem Execute jaxrx-demo
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %JAXRX_DEMO_OPTS%  -classpath "%CLASSPATH%" com.dgstack.eg.jaxrx.App %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable JAXRX_DEMO_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%JAXRX_DEMO_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
