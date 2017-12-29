package lchj.kt.user.utils.file

import java.io.File
import java.io.FileInputStream
import java.text.DecimalFormat

/**
 * 文件或文件夹操作工具类
 *
 */
object FileInfoUtils {
    /**
     * 返回自定文件或文件夹的大小
     *
     * @param f
     * @return
     * @throws Exception
     */
    @Throws(Exception::class)
    fun getFileSizes(f: File): Long {// 取得文件大小
        var s: Long = 0
        if (f.exists()) {
            val fis = FileInputStream(f)
            s = fis.available().toLong()
            fis.close()
        } else {
            f.createNewFile()
            println("文件不存在")
        }
        return s
    }

    // 递归
    @Throws(Exception::class)// 取得文件夹大小
    fun getFileSize(f: File): Long {
        var size: Long = 0
        val flist = f.listFiles()
        for (i in flist.indices) {
            if (flist[i].isDirectory) {
                size = size + getFileSize(flist[i])
            } else {
                size = size + flist[i].length()
            }
        }
        return size
    }

    fun FormetFileSize(fileS: Long): String {// 转换文件大小
        val df = DecimalFormat("#0.00")
        var fileSizeString = ""
        if (fileS < 1024) {
            fileSizeString = df.format(fileS.toDouble()) + "B"
        } else if (fileS < 1048576) {
            fileSizeString = df.format(fileS.toDouble() / 1024) + "K"
        } else if (fileS < 1073741824) {
            fileSizeString = df.format(fileS.toDouble() / 1048576) + "M"
        } else {
            fileSizeString = df.format(fileS.toDouble() / 1073741824) + "G"
        }
        return fileSizeString
    }

    fun getlist(f: File): Long {// 递归求取目录文件个数
        var size: Long = 0
        val flist = f.listFiles()
        size = flist.size.toLong()
        for (i in flist.indices) {
            if (flist[i].isDirectory) {
                size = size + getlist(flist[i])
                size--
            }
        }
        return size

    }
}