# coding=utf-8

import tensorflow as tf

# 创建常量
hello = tf.constant("Hello Tensorflow")

sess = tf.Session()

print(sess.run(hello))

