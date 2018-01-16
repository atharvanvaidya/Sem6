#include<jni.h>
#include<math.h>
#include<stdio.h>
#include<string.h>
#include"cal.h"

//Implementations of the Methods of cal Class.
JNIEXPORT jint JNICALL Java_cal_add(JNIEnv *env, jobject obj, jint a, jint b)
{
	return(a+b);
}
JNIEXPORT jint JNICALL Java_cal_sub(JNIEnv *env, jobject obj, jint a, jint b)
{
	return(a-b);
}
JNIEXPORT jint JNICALL Java_cal_mul(JNIEnv *env, jobject obj, jint a, jint b)
{
	return(a*b);
}
JNIEXPORT jint JNICALL Java_cal_div(JNIEnv *env, jobject obj, jint a, jint b)
{
	return((b == 0)?(0):(a/b));
}
JNIEXPORT jdouble JNICALL Java_cal_s(JNIEnv *env, jobject obj, jint a)
{
        return(sin(a * 3.1415 / 180));
}
JNIEXPORT jdouble JNICALL Java_cal_c(JNIEnv *env, jobject obj, jint a)
{
        return(cos(a * 3.1415 / 180));
}
JNIEXPORT jstring JNICALL Java_cal_conc(JNIEnv *env, jobject obj, jstring x, jstring y)
{
	const char* x1;
	const char* y1;
	char* res;
	x1 = (*env)->GetStringUTFChars(env,x,NULL);
	y1 = (*env)->GetStringUTFChars(env,y,NULL);
	int x1size = (*env)->GetStringUTFLength(env,x);
	int y1size = (*env)->GetStringUTFLength(env,y);
	int counter=0,i;
	for(i = 0 ; i < x1size ; i++)
	{
		res[i] = x1[i];
	}
	for(i = 0 ; i < (y1size) ; i++)
	{
		res[x1size+i] = y1[i];
	}
	int total = x1size+y1size;
	res[total] = '\0';
	
	//strcat(x1,y1);
	return (*env)->NewStringUTF(env,res);
	//return x1;
}
