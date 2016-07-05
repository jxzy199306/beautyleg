# Android proguard 混淆模板
 #指定代码的压缩级别
    -optimizationpasses 5
    #不去忽略非公共的库类
    -dontskipnonpubliclibraryclasses

     #优化  不优化输入的类文件

  -packageobfuscationdictionary dictionary.txt
   -obfuscationdictionary dictionary.txt
   -classobfuscationdictionary dictionary.txt

     #预校验
    -dontpreverify

     #混淆时是否记录日志
    -verbose

     # 混淆时所采用的算法
   # -optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

    #保护注解
    -keepattributes *Annotation*

    # 保持哪些类不被混淆
    -keep public class * extends android.app.Fragment
    -keep public class * extends android.app.Activity
    -keep public class * extends android.app.Application
    -keep public class * extends android.app.Service
    -keep public class * extends android.content.BroadcastReceiver
    -keep public class * extends android.content.ContentProvider
    -keep public class * extends android.app.backup.BackupAgentHelper
    -keep public class * extends android.preference.Preference
    -keep public class com.android.vending.licensing.ILicensingService
    #如果有引用v4包可以添加下面这行
    -keep public class * extends android.support.v4.app.Fragment

    -ignorewarning

    -dump class_files.txt
    #未混淆的类和成员
    -printseeds seeds.txt
    #列出从 apk 中删除的代码
    -printusage unused.txt
    #混淆前后的映射
    -printmapping mapping.txt

    #如果不想混淆 keep 掉
    -keep class com.lippi.recorder.iirfilterdesigner.** {*; }

        -keep class com.liulishuo.filedownloader.** {*; }
    #友盟
    -keep class com.umeng.**{*;}
    #项目特殊处理代码

    -keep class com.qtfreet.beautyleg.data.bean.**{*;}
    -keep class tv.danmaku.ijk.media.player.**{*;}
    -keep class com.pgyersdk.**{*;}

    #忽略警告
    -dontwarn com.lippi.recorder.utils**
    #保留一个完整的包
    -keep class com.lippi.recorder.utils.** {
        *;
     }
    #如果引用了v4或者v7包
    -dontwarn android.support.**


    -keep public class * extends android.view.View {
        public <init>(android.content.Context);
        public <init>(android.content.Context, android.util.AttributeSet);
        public <init>(android.content.Context, android.util.AttributeSet, int);
        public void set*(...);
    }

    -keepclasseswithmembernames class * {
        native <methods>;
    }

    -keepclasseswithmembers class * {
        public <init>(android.content.Context, android.util.AttributeSet);
    }

    -keepclassmembers class * extends android.app.Activity {
       public void *(android.view.View);
    }

    -keep class * implements android.os.Parcelable {
      public static final android.os.Parcelable$Creator *;
    }

    -keepnames class * implements java.io.Serializable


    -keepclassmembers class * implements java.io.Serializable {
        static final long serialVersionUID;
        private static final java.io.ObjectStreamField[] serialPersistentFields;
        !static !transient <fields>;
        !private <fields>;
        !private <methods>;
        private void writeObject(java.io.ObjectOutputStream);
        private void readObject(java.io.ObjectInputStream);
        java.lang.Object writeReplace();
        java.lang.Object readResolve();
    }


    -keepclassmembers class * {
        public void *ButtonClicked(android.view.View);
    }

    -keepclassmembers class **.R$* {
        public static <fields>;
    }



    -keep class butterknife.** { *; }
    -dontwarn butterknife.internal.**
    -keep class **$$ViewBinder { *; }

    -keepclasseswithmembernames class * {
        @butterknife.* <fields>;
    }

    -keepclasseswithmembernames class * {
        @butterknife.* <methods>;
    }

    #okhttputils
    -dontwarn com.zhy.http.**
    -keep class com.zhy.http.**{*;}


    #okhttp
    -dontwarn okhttp3.**
    -keep class okhttp3.**{*;}


    #okio
    -dontwarn okio.**
    -keep class okio.**{*;}
    -dontwarn retrofit2.**
    -keep class retrofit2.** { *; }
    -keepattributes Signature
    -keepattributes Exceptions

    -keepattributes Signature

    -keep class sun.misc.Unsafe { *; }

    -keep class com.google.gson.**{*;}
