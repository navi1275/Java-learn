# Markdown 语法

## Markdown 的设计哲学

> Markdown 的目标是实现「易读易写」。
> 不过最需要强调的便是它的可读性。一份使用 Markdown 格式撰写的文件应该可以直接以纯文字发布，并且看起來不会像是由许多标签或是格式指令所构成。
> Markdown 的语法有个主要的目的：用来作为一种网路內容的*写作*用语言。

## 标题

Markdown 语法：

```markdown
# 第一级标题 `<h1>` 
## 第二级标题 `<h2>` 
###### 第六级标题 `<h6>` 
```
效果如下：

# 第一级标题 `<h1>` 

## 第二级标题 `<h2>` 

###### 第六级标题 `<h6>` 



## 强调

Markdown 语法：

```markdown
*这些文字会生成`<em>`*
_这些文字会生成`<u>`_
**这些文字会生成`<strong>`**
__这些文字会生成`<strong>`__
```

效果如下：

*这些文字会生成`<em>`*
_这些文字会生成`<u>`_
**这些文字会生成`<strong>`**
__这些文字会生成`<strong>`__

## 换行

四个及以上空格加回车。

## 列表

### 无序列表

Markdown 语法：

```markdown
* 项目一 无序列表 `* + 空格键`
* 项目二
* 项目二的子项目一 无序列表 `TAB + * + 空格键`
* 项目二的子项目二
```

效果如下：

* 项目一 无序列表 `* + 空格键`
* 项目二
* 项目二的子项目一 无序列表 `TAB + * + 空格键` 
   * df
* 项目二的子项目二

### 有序列表

Markdown 语法：

```markdown
1. 项目一 有序列表 `数字 + . + 空格键`
2. 项目二 
3. 项目三
	1. 项目三的子项目一 有序列表 `TAB + 数字 + . + 空格键`
	2. 项目三的子项目二
```
效果如下：

1. 项目一 有序列表 `数字 + . + 空格键`
2. 项目二 
3. 项目三
​    1. 项目三的子项目一 有序列表 `TAB + 数字 + . + 空格键`
​    2. fd 
​    3. 项目三的子项目二

### 任务列表（Task lists）

Markdown 语法：

```markdown
- [ ] 任务一 未做任务 `- + 空格 + [ ]`
- [x] 任务二 已做任务 `- + 空格 + [x]`
```
效果如下：

- [ ] 任务一 未做任务 `- + 空格 + [ ]`
- [x] 任务二 已做任务 `- + 空格 + [x]`

## 图片

Markdown 语法：

```markdown
![GitHub set up](http://zh.mweb.im/asset/img/set-up-git.gif)
格式: ![Alt Text](url)
```


效果如下：

![GitHub set up](http://zh.mweb.im/asset/img/set-up-git.gif)

## 链接

Markdown 语法：

```markdown
email <example@example.com>
[GitHub](http://github.com)
自动生成连接  <http://www.github.com/>
```


效果如下：

Email 连接： <example@example.com>
[连接标题Github网站](http://github.com)
自动生成连接像： <http://www.github.com/> 这样

## 区块引用

Markdown 语法：

```markdown
某某说:
> 第一行引用
> 第二行费用文字
```

效果如下：

某某说:
> 第一行引用
> 第二行费用文字

## 行内代码

Markdown 语法：

```markdown
像这样即可：`<addr>` `code`
```
效果如下：

像这样即可：`<addr>` `code`

## 多行或者一段代码

Markdown 语法：

​    ```js
​    function fancyAlert(arg) {
​        if(arg) {
​        	$.facebox({div:'#foo'})
​        }
​    }
​    ```

效果如下：



```js
function fancyAlert(arg) {
	if(arg) {
		$.facebox({div:'#foo'})
	}
}
```

```java
public class Demo{
	public static void main(String[] args){
        System.out.println("Hello World");
	}   
}
```
## 顺序图或流程图

Markdown 语法：
```markdown
​```sequence
张三->李四: 嘿，小四儿, 写博客了没?
Note right of 李四: 李四愣了一下，说：
李四-->张三: 忙得吐血，哪有时间写。
​```

​```flow
st=>start: 开始
e=>end: 结束
op=>operation: 我的操作
cond=>condition: 确认？
st->op->cond
cond(yes)->e
cond(no)->op
​```
```

效果如下：

```sequence
张三->李四: 嘿，小四儿, 写博客了没?
Note right of 李四: 李四愣了一下，说：
李四-->张三: 忙得吐血，哪有时间写。
```

```flow
st=>start: 开始
e=>end: 结束
op=>operation: 我的操作
cond=>condition: 确认？
st->op->cond
cond(yes)->e
cond(no)->op
```

更多请参考：<http://bramp.github.io/js-sequence-diagrams/>, <http://adrai.github.io/flowchart.js/>

## 表格

Markdown 语法：

```markdown
第一格表头 | 第二格表头
--------- | -------------
内容单元格 第一列第一格 | 内容单元格第二列第一格
内容单元格 第一列第二格 多加文字 | 内容单元格第二列第二格
```

效果如下：

第一格表头 | 第二格表头
--------- | -------------
内容单元格 第一列第一格 | 内容单元格第二列第一格
内容单元格 第一列第二格 多加文字 | 内容单元格第二列第二格

## 删除线

Markdown 语法：

加删除线像这样用： `~~删除这些~~`

效果如下：

加删除线像这样用： ~~删除这些~~

## 分隔线

以下三种方式都可以生成分隔线：

```markdown
***
*****
- - -
```

效果如下：

***
*****
- - -

## MathJax

Markdown 语法：

```markdown
块级公式：
$$    x = \dfrac{-b \pm \sqrt{b^2 - 4ac}}{2a} $$
行内公式： $\Gamma(n) = (n-1)!\quad\forall n\in\mathbb N$
```
效果如下：

块级公式：

$$    x = \dfrac{-b \pm \sqrt{b^2 - 4ac}}{2a} $$

行内公式： $\Gamma(n) = (n-1)!\quad\forall n\in\mathbb N$

## 脚注（Footnote）

Markdown 语法：

```markdown
这是一个脚注：[^sample_footnote]
```
效果如下：

这是一个脚注：[^sample_footnote]

[^sample_footnote]: 这里是脚注信息

## 注释和阅读更多

<!-- comment -->
<!-- more -->

**注** 阅读更多的功能只用在生成网站或博客时，插入时注意要后空一行。

## TOC

Markdown 语法：

```markdown
[TOC]
```
效果如下：

[TOC]