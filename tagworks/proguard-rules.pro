# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


# ====================== [proguard 중요 사항] ========================

# 1. 난독화 적용 시 외부 라이브러리 및 jar 파일 사용 시 패키지 명을 확인해서 난독화 제외 설정 필요 (특정 객체 초기화 부분 클래스에서 패키지명 파악)

# 2. 프로젝트 설정 부분에서 release 모드와 debug 모드 나눠서 설정 가능

# ==================================================================

# ====================== [proguard option] =========================

#-dontwarn 패키지명.** : 지정해서 경고 무시

#-keep class 패키지명.** : 난독화가 필요하지 않은 경우

#-keep interface 패키지명.** : 난독화가 필요하지 않은 경우

#-ignorewarnings : 경고 무시

#-dontoptimize : 최적화 하지 않기

#-dontshrink : 사용하지 않는 메소드 유지

#-keepclassmembers : 특정 클래스 멤버 원상태 유지

#-keepattributes : 내부 클래스 원상태 유지 적용

#-dontshrink : 사용하지 않는 메소드 유지 설정

#-dontoptimize : 최적화하지 않음

#-dontobfuscate : 난독화를 수행 하지 않도록 함

#-verbose : 로그봄 설정

#-ignorewarnings : 경고 무시

#-dontpreverify : 사전 검증기능을 사용하지 않음

#-dontusemixedcaseclassnames : 대소문자가 혼합된 클래스명을 허용하지 않음

# ==================================================================

# ====================== [project settings] ========================

# [디버깅 모드에서 난독화 제외 설정]
#-dontshrink
#-dontoptimize
#-dontobfuscate

-dontshrink
-ignorewarnings
-keepparameternames
-keepattributes Exceptions,InnerClasses,Signature,Deprecated,
        SourceFile,LineNumberTable,*Annotation*,EnclosingMethod

# ==================================================================

# =========================  [TagWorks]  ===========================

#-keep class com.obzen.tagworks.TagWorks { *; }
#-keep class com.obzen.tagworks.TagWorksConfig { *; }
#-keep class com.obzen.tagworks.constants.** { *; }

-keep interface * {
   public protected <methods>;
}
-keepclassmembernames class * {
    public protected <methods>;
}
