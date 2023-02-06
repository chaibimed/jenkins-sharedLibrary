import java.io.*;
import groovy.io.*;

def call(Map config=[:]) {
  def dir = new File(pwd());
  @NonCPS
  new File(dir.path + '\\releasenotes.txt').withWriter('utf-8')
  {
    writer -> dir.eachFileRecurse(FileType.ANY){ file ->
       writer.writeLine('\t' + file.name +'\t' + file.length());
    }
  }
}
