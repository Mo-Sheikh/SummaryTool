import os 
import sys
import os.path
import subprocess
import shutil

source = (r'C:\SVN\UMIProjects\DNDS_DecodedNavDataStore_I_U_INT\Cantata\tests\test_T_DNDS_DecodedNavDataStore\test_T_DNDS_DecodedNavDataStore.c')

destination = r'C:\Users\mohamed.sheikh\Music\SumTool\src\file.txt'


shutil.copy(source,destination)

def compile_java(java_file):
    cmd = 'javac ' + java_file 
    proc = subprocess.Popen(cmd, shell=True)

compile_java("helperTool.java")

def execute_java(java_file):
    cmd = 'java', java_file
    proc = subprocess.Popen(cmd, shell=True)
execute_java("helperTool")






