![](https://images.xiaozhuanlan.com/photo/2021/dda931ef821b43f698d04be4ef9b92de.png)

[《重学安卓》](https://xiaozhuanlan.com/kunminx)订阅读者加微信进群：myatejx

&nbsp;

# 《重学安卓》两周年，回顾与展望

我们于 2019 年 6 月，在小专栏开设了《重学安卓》付费专栏，

迄今为止，我们共连接了 1111 名优秀开发者，并且期间不断有小伙伴告诉我，受专栏内容的影响和启发，他们也开启了写作之路，

这里面就包括 专注 ROM 开发多年、现就职于快手的 [Flywith24](https://juejin.cn/user/219558054476792/activities)，也包括 [Bezier](https://juejin.cn/user/2629687546479742/posts) 等对写作技能精益求精的明日之星。



# 以 “深度思考” 为立足之本

在过去两年里，我们以 “架构组件” 为话题，不遗余力地在每篇文章中贯彻落实 **基于 “第一性原理” 和 “实事求是” 精神的深度思考方式**，

在 “深度思考” 的帮助下，以及基于对大量样本的追踪和反思，我们独树一帜地从软件工程的视角出发抓住本质，并开源了一系列高频使用的仓库，

包括 腾讯音乐、BMW、TCL 等知名厂商的软件，都在使用我们正在维护的[《UnPeek-LiveData》](https://github.com/KunMinX/UnPeek-LiveData)等仓库。

![](https://images.xiaozhuanlan.com/photo/2021/b00e3594f28296671962ccc0c13f6ceb.png)



# 不小心当了回 “万恶之源”

不知何时起，你是否经常在 培训机构软文 或网文中看到 “一致性” 等令人迷惑的说辞？

这些术语在 Android 领域是从未有过，网上关于 “一致性问题” 等说辞，它们都有一个共同的来源，

事实上，这些术语都是本人经由长期的深度思考、实践和交流后，为现象本质匹配的高度概括，《重学安卓》与之相对应的每一篇文章都 **提供了 背景缘由、职责边界 等完整的解析过程**，

![](https://images.xiaozhuanlan.com/photo/2021/60b9c3360b57553f3a21b345a1a9de37.jpg)

但十分令人遗憾的是，本是从 “实事求是” 出发概括的术语，却频繁被人拿去 “点缀文章” 和 “挂羊头卖狗肉”，这些无厘头的滥用行为，无形中扭曲和破坏了术语 “实事求是” 的形象，

所以过去两年里，我们积极地举报 “培训机构的洗稿软文”，以及在相关文章的评论区补充参考文献来源，

非常感谢小伙伴们的主动反馈。



# 本质概括一览

基于深度思考，我们确立下来并广泛传播的 “本质概括” 包括但不限于：



### Jetpack 架构组件本质：

Lifecycle 的本质是解决 “生命周期管理” 的一致性问题

LiveData 的本质是解决 “跨域消息同步” 的一致性问题

ViewModel 的本质是解决 “状态保存恢复” 的一致性问题

DataBinding 的本质是解决 “视图实例的 null 安全” 的一致性问题

Navigation 的本质是解决 “路由初始参数恢复” 的一致性问题

…

若要说它们有什么共性的话，就是透过各种方式 **实现样板逻辑的 “内聚”**，从而达到规避一致性问题的目的。

> 文章来源
>
> [《是让人耳目一新的 Jetpack MVVM 精讲》](https://juejin.cn/post/6844903976240939021)
>
> [《是架构组件 “一致性” 概念的全面解析》](https://xiaozhuanlan.com/topic/9340256871)
>
> ·
>
> [《为你还原一个真实的 Jetpack Lifecycle》](https://xiaozhuanlan.com/topic/3684721950)
>
> [《就算不用 Jetpack Navigation，也请务必领略的声明式编程之美》](https://xiaozhuanlan.com/topic/5860149732)
>
> [《LiveData 鲜为人知的 身世背景 和 独特使命》](https://xiaozhuanlan.com/topic/0168753249)
>
> [《有了 Jetpack ViewModel . . . 真的可以为所欲为》](https://xiaozhuanlan.com/topic/6257931840)
>
> [《从 被误解 到 真香 的 Jetpack DataBinding》](https://xiaozhuanlan.com/topic/9816742350)



### 声明式 UI 本质：

声明式 UI 的本质是函数式编程，

函数式编程的基石是纯函数，

纯函数的特性是 **只有一个入口、只有一个出口**，且无副作用，

声明式 UI 正是通过对视图实例的屏蔽，来规避 “视图实例的 null 安全” 的一致性问题，

![](https://images.xiaozhuanlan.com/photo/2020/f47f2111348d4e927e446e37379df502.gif)

也即声明式 UI 可用于替代 DataBinding 等框架，

如果公司项目执意使用 Java，为了规避 null 安全问题，务必使用 DataBinding 等框架，

**如果允许使用 kotlin，那么当下 kotlin + ViewBinding 的组合是更优解**。

> 文章来源
>
> [《是 “一通百通” 的 声明式 UI 扫盲干货》](https://xiaozhuanlan.com/topic/2356748910)
>
> [《从 被误解 到 真香 的 Jetpack DataBinding》](https://xiaozhuanlan.com/topic/9816742350)



### 架构模式本质：

MVP 的本质是基于 “依赖倒置原则” 实现组件的可替换，适合非页面开发场景的编写（具体可参见我开源的 Linkage-RecyclerView 中万用的适配器），

MVVM 的本质是基于 “数据绑定” 来解决视图实例 null 安全一致性问题，也即它是专用于页面开发的模式，

当我们剔除了 DataBinding 框架而使用 Compose 或 kotlin + ViewBinding 等方式来规避一致性问题，虽然效果是等同的，但已不能称作是 MVVM。

> 文章来源
>
> [《如何让同事爱上架构模式、少写 bug 多注释》](https://xiaozhuanlan.com/topic/8204519736)
>
> [《是让人提神醒脑的 MVP、MVVM 关系精讲》](https://xiaozhuanlan.com/topic/6105792348)



### LiveData 的那些事：

LiveData 的设计存在缺陷。

一方面它提供了面向 “事件” 的设计，

这使得我们萌生了通过 **“决策权收紧” 的结构**（也即所谓 “唯一可信源”）来确保 “消息分发可靠一致” 的目的成为可能，

另一方面它权当自己是 “状态”，而仅提供粘性的设计，

正是这种令人迷惑的设计，导致了所谓 “数据倒灌” 现象的发生。

要想弄清楚 “唯一可信源” 和 “数据倒灌”，得先正确理解和区分 “状态” 和 “事件”。

> 文章来源
>
> [《LiveData 唯一可信源 读写分离设计 独家解析》](https://xiaozhuanlan.com/topic/2049857631)
>
> [《LiveData 数据倒灌 背景缘由全貌 独家解析》](https://xiaozhuanlan.com/topic/6719328450)



# 开源项目一览

包括 腾讯音乐、字节跳动直播 在内的诸多厂商或团队，参考过或正在使用我们开源和维护的《脚手架》等项目，

> https://github.com/KunMinX/Jetpack-MVVM-Scaffold

解决 LiveData 数据倒灌问题的 UnPeek-LiveData

> https://github.com/KunMinX/UnPeek-LiveData

解决 Navigation 转场卡顿的 Smooth-Navigation

> https://github.com/KunMinX/Smooth-Navigation

我和 Flywith24 合作开发维护的 Jetpack MVVM -  Java to Kotlin 示例

> https://github.com/Jetpack-Missionary/Jetpack-From-Java-To-Kotlin

作为依赖倒置原则 MVP 的 Linkage-RecyclerView

> https://github.com/KunMinX/Linkage-RecyclerView



# 对未来的展望

《重学安卓》发展至今，已从单纯的写作专栏，演化为高手云集的社群，这里平均每两周一位小伙伴告知自己入职字节跳动，也有来自 HencoderPlus 的小伙伴不断加入，

关于写作，《重学安卓》一直保持初心，只写揭露本质的 “深度思考” 文章，授人以鱼且授人以渔。

![](https://images.xiaozhuanlan.com/photo/2021/27103b7673c9319770793642ace58028.jpg)

比起无原则的盲目扩充，我们选择慎重选题和长期修订打磨，确保能恰到好处地覆盖到 关于某领域的 来龙去脉、各式场景、最新动态，

![](https://images.xiaozhuanlan.com/photo/2021/7079b7090c7bc272f5904251b49bf044.jpg)

并且考虑到部分读者有截图收藏的需要，我们逐步为专栏文章增设 “语录卡片”，方便已订阅的读者保存到手机、随时查看、以及通过二维码直达原文重温。

![](https://tva1.sinaimg.cn/large/008i3skNly1gr7lp9o0t8j31400u04qp.jpg)

最后，感谢小伙伴们一直以来的关心和支持！


&nbsp;

# 版权声明

本项目的场景、外观、代码设计，由作者 [KunMinX](https://github.com/KunMinX) 独立原创，作者对此享有著作权，任何个人或组织，未经作者本人授权，不得将该项目的设计用于写书、卖课等商业用途。

Copyright © 2019-present KunMinX

