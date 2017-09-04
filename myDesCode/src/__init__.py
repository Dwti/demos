# coding:utf-8 
import io
from tkinter import*
from doctest import master
from distutils.dist import command_re
import pyDes
import base64


from tkinter import *
import tkinter.messagebox as messagebox
from logging import log
from _overlapped import NULL

class Application(Frame):
   
    #类的构造函数
  
    def __init__(self, master=None):
        Frame.__init__(self, master)
        self.pack()
        self.createWidgets()  

    def createWidgets(self):

#         self.nameInput = Entry(self)
#         self.nameInput.pack()
#         self.alertButton = Button(self, text='确定', command=self.hello)
#         self.alertButton.pack()

#         self.parentCode=Entry(self)
#         self.parentCode.pack()
#         self.childCode=Entry(self)
#         self.childCode.pack()
        self.inputContent = Text(height=20)
        self.inputContent.pack()
            
        self.button1 = Button(text="开始解密", fg="blue", command=self.decrypt)
        self.button1.pack()
            
        self.resultContent = Text(height=20)
        self.resultContent.pack();
        
        

     
#     def hello(self):
#         name = self.nameInput.get() or 'world'
#         messagebox.showinfo('Message', 'Hello, %s' % name)
    def decrypt(self):
        self.resultContent.delete("1.0", END)
        encrypt_data = self.inputContent.get("1.0", END)
        base64_data = base64.b64decode(encrypt_data)
        des_key = pyDes.des("ws3edaw4", pyDes.ECB, "\0\0\0\0\0\0\0\0", pad=None, padmode=pyDes.PAD_PKCS5)
        decrypt_data = des_key.decrypt(base64_data, padmode=pyDes.PAD_PKCS5)
        self.resultContent.insert(END, decrypt_data.decode('utf8'))
    # print("hell world")
        
app = Application()
# 设置窗口标题: 
app.master.title('解密')
# 主消息循环:
app.mainloop()
    