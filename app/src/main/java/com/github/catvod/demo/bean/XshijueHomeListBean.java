package com.github.catvod.demo.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class XshijueHomeListBean {


    /**
     * list : [{"vod_id":"151064","vod_name":"绑架2023","vod_pic":"https://img.lzzyimg.com/upload/vod/20231118-1/68693ae573c4f9303e762d8ab0ae1074.jpg","vod_remarks":""},{"vod_id":"151063","vod_name":"错误行动","vod_pic":"https://img.lzzyimg.com/upload/vod/20231118-1/57c7e963b24b9bab7d05528bc965d5c3.jpg","vod_remarks":""},{"vod_id":"150111","vod_name":"无穷之路3：无垠之疆粤语","vod_pic":"https://svip.picffzy.com/upload/vod/20231109-1/7e59a9bba21d3d61dd8d969b6a752ab3.jpg","vod_remarks":""},{"vod_id":"151059","vod_name":"OMG! 我爱你 但不合时宜","vod_pic":"https://image.jinyingimage.com/cover/2300f9ba076cf272c75c708ba6b92403.jpg","vod_remarks":""},{"vod_id":"151058","vod_name":"性游戏","vod_pic":"https://image.jinyingimage.com/cover/a0b663e2e7d1b8d10af347c43bdb05a0.jpg","vod_remarks":""},{"vod_id":"151057","vod_name":"身为人父","vod_pic":"https://image.jinyingimage.com/cover/d35416ae39b6977253a4a4e7bff81c19.jpg","vod_remarks":""},{"vod_id":"151056","vod_name":"毒战","vod_pic":"https://image.jinyingimage.com/cover/691990f4af442c69f85a12a8f0ceeaff.jpg","vod_remarks":""},{"vod_id":"151055","vod_name":"大谷翔平 超越梦想","vod_pic":"https://image.jinyingimage.com/cover/f2735a800fe6b68a5117504cbec84752.jpg","vod_remarks":""},{"vod_id":"151054","vod_name":"诞生","vod_pic":"https://image.jinyingimage.com/cover/926f3deae51179280cd8c29d2c280763.jpg","vod_remarks":""},{"vod_id":"151050","vod_name":"零落","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/6e2bdf5677d5e62d75540d8bec7d94d0.jpg","vod_remarks":""},{"vod_id":"151040","vod_name":"鲁斯丁","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/325b7a07dd27426f8a90544853dcc3ce.jpg","vod_remarks":""},{"vod_id":"151031","vod_name":"狂奔向圣诞","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/4d056a43490deb899dde405ba019a114.jpg","vod_remarks":""},{"vod_id":"149019","vod_name":"冰上火花","vod_pic":"https://img.xmchwl.com:777/upload/vod/20231031-1/917742deaf420b37de9375f8578d0f7f.jpg","vod_remarks":""},{"vod_id":"149385","vod_name":"High Cookie","vod_pic":"https://svip.picffzy.com/upload/vod/20231104-1/1c18606a02d8520d33856e31cff64058.jpg","vod_remarks":""},{"vod_id":"146953","vod_name":"闪谷第二季","vod_pic":"https://svip.picffzy.com/upload/vod/20231013-1/623808047efe28bbe0a45b32305605d9.jpg","vod_remarks":""},{"vod_id":"151052","vod_name":"神圣之家 第二季","vod_pic":"https://image.jinyingimage.com/cover/5ca0ff28ba7dcad8e1c31e62e5722b59.jpg","vod_remarks":""},{"vod_id":"149327","vod_name":"故乡，别来无恙","vod_pic":"https://image.jinyingimage.com/cover/d3a1e553f6624c0051892aef67f38bca.jpg","vod_remarks":""},{"vod_id":"146957","vod_name":"闪谷 第二季","vod_pic":"https://image.jinyingimage.com/cover/b83a52c035258ed43d787106b1765e35.jpg","vod_remarks":""},{"vod_id":"151016","vod_name":"新闻女王国语","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/903a846e0505f6a94cfb0f636068cbd5.jpg","vod_remarks":""},{"vod_id":"151015","vod_name":"新闻女王粤语","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/e19ec44206e57de3773537a938520a7a.jpg","vod_remarks":""},{"vod_id":"150805","vod_name":"老大夫小大夫","vod_pic":"https://svip.picffzy.com/upload/vod/20231116-1/a26a3ddc05c3364d155be6ba1c487074.jpg","vod_remarks":""},{"vod_id":"149323","vod_name":"无所畏惧","vod_pic":"https://image.jinyingimage.com/cover/760e8964cb1ca4375ec8eff22e08346c.jpg","vod_remarks":""},{"vod_id":"148899","vod_name":"宣判","vod_pic":"https://svip.picffzy.com/upload/vod/20231030-1/b1b77b3ffaf297486f97f23282fb5a54.jpg","vod_remarks":""},{"vod_id":"148882","vod_name":"我要逆风去","vod_pic":"https://svip.picffzy.com/upload/vod/20231030-1/c9ed42803711f243815c08c9acfab729.jpg","vod_remarks":""},{"vod_id":"149387","vod_name":"娱乐头条粤语","vod_pic":"https://svip.picffzy.com/upload/vod/20231102-1/ce21665d5e2b7fad48af1de2639a3ce4.jpg","vod_remarks":""},{"vod_id":"149269","vod_name":"流行都市粤语","vod_pic":"https://svip.picffzy.com/upload/vod/20231102-1/4a1f11ee35a565f350d81c8d92ca99e2.jpg","vod_remarks":""},{"vod_id":"147895","vod_name":"玲玲友情报粤语","vod_pic":"https://svip.picffzy.com/upload/vod/20231021-1/c5827c91d3e51338b2078d0ee4ef1eea.jpg","vod_remarks":""},{"vod_id":"146963","vod_name":"超燃美食记第三季","vod_pic":"https://img.lzzyimg.com/upload/vod/20231013-1/dddc881d8fee3a61e1cdb8f07adaaf7a.jpg","vod_remarks":""},{"vod_id":"144650","vod_name":"非来不可","vod_pic":"https://image.jinyingimage.com/cover/5804a7bec176070ba227bdeaa23c5913.jpg","vod_remarks":""},{"vod_id":"151062","vod_name":"你好新声","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/07bc06e6a226f652aaf95a92212f524a.jpeg","vod_remarks":""},{"vod_id":"151061","vod_name":"也许你要恋爱了","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/6148b3ab0a7942d280270b67e548e31f.jpg","vod_remarks":""},{"vod_id":"151060","vod_name":"亲爱的学弟学妹","vod_pic":"https://puui.qpic.cn/vcover_vt_pic/0/mzc00200inpl8f51700110951420/260","vod_remarks":""},{"vod_id":"150296","vod_name":"乐高大师第二季","vod_pic":"https://img.lzzyimg.com/upload/vod/20231110-1/ca0b11bad569c0711d23f29d440e5191.jpg","vod_remarks":""},{"vod_id":"147718","vod_name":"王牌对王牌第八季","vod_pic":"https://svip.picffzy.com/upload/vod/20231020-1/039bce2bba19b373bbec93ad8ed3cec7.jpg","vod_remarks":""},{"vod_id":"109656","vod_name":"传奇故事2023","vod_pic":"https://pic.lzzypic.com/upload/vod/20230421-1/9915576c8d206733c1656737eddcd813.jpg","vod_remarks":""},{"vod_id":"147761","vod_name":"王牌对王牌 第八季","vod_pic":"https://img.xmchwl.com:777/upload/vod/20231021-1/46b3a995f0ef2dea0a9144c34ca6de20.jpg","vod_remarks":""},{"vod_id":"144635","vod_name":"逆天邪神3D","vod_pic":"https://image.ffzyimg.com/upload/vod/20230923-1/476e9da16ec35dc9c9753e92e42d7d62.jpg","vod_remarks":""},{"vod_id":"96354","vod_name":"武映三千道","vod_pic":"https://image.iapijy.com/cover/1797cf9a4a822db5cc555d8a9940eba7.jpg","vod_remarks":""},{"vod_id":"172","vod_name":"五行战神","vod_pic":"https://img.ffzypic.com/upload/vod/20230704-1/8859d40c6b653a70876d80a3be711f4b.jpg","vod_remarks":""},{"vod_id":"170","vod_name":"斗罗大陆2：绝世唐门","vod_pic":"https://img.ffzypic.com/upload/vod/20230624-1/c672d5cab2026eefeaf8e8049ca88de3.jpg","vod_remarks":""},{"vod_id":"168","vod_name":"炼气十万年","vod_pic":"https://img.ffzypic.com/upload/vod/20230218-1/1c58e8c9d52c6b9e735fac4a3ba9c0d8.jpg","vod_remarks":""},{"vod_id":"167","vod_name":"万界独尊","vod_pic":"https://img.ffzypic.com/upload/vod/20221115-1/cffba54c5b8771c817f843fe70d2804a.jpg","vod_remarks":""},{"vod_id":"145371","vod_name":"我就是不按套路出牌","vod_pic":"https://svip.picffzy.com/upload/vod/20230930-1/7952b7e40702887f4b2d36cdbacf0f2d.jpg","vod_remarks":""},{"vod_id":"3304","vod_name":"动态漫画·全球诡异时代","vod_pic":"https://img.ffzypic.com/upload/vod/20230708-1/e198495285890a048dc9d1231e68dc17.jpg","vod_remarks":""},{"vod_id":"146111","vod_name":"明日方舟：冬隐归路日语","vod_pic":"https://svip.picffzy.com/upload/vod/20231007-1/99bed9adbce81e49b5d0fc11ff89faa1.jpg","vod_remarks":""},{"vod_id":"146112","vod_name":"明日方舟：冬隐归路国语","vod_pic":"https://svip.picffzy.com/upload/vod/20231007-1/244cd6b0bf725748346f28d98ecc04c6.jpg","vod_remarks":""},{"vod_id":"146098","vod_name":"催眠麦克风第二季","vod_pic":"https://svip.picffzy.com/upload/vod/20231007-1/2f3ef0f75fef1c4b55ab2645357778a4.jpg","vod_remarks":""},{"vod_id":"151042","vod_name":"歪小子斯科特：火力全开","vod_pic":"https://svip.picffzy.com/upload/vod/20231117-1/cea316bca2a120ef6a4297671851c7ca.jpg","vod_remarks":""},{"vod_id":"151020","vod_name":"风流断剑小小刀[电影解说]","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/c6443edba401dba8895e4f08f3bb5c32.jpg","vod_remarks":""},{"vod_id":"150989","vod_name":"血符门[电影解说]","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/2e82e172a1ff5cc2a633305009131d0a.jpg","vod_remarks":""},{"vod_id":"150988","vod_name":"鹰王[电影解说]","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/5000e091c013e0d580ad70cd13fea92e.jpg","vod_remarks":""},{"vod_id":"150987","vod_name":"少林寺十八铜人[电影解说]","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/a70e598ede122b1ef443f52ed043b857.jpg","vod_remarks":""},{"vod_id":"150986","vod_name":"幽灵山庄[电影解说]","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/43296481aac8966616467238c24ac6a3.jpg","vod_remarks":""},{"vod_id":"150985","vod_name":"侠客行1982[电影解说]","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/f212410564c94b49b549399b2755c640.jpg","vod_remarks":""},{"vod_id":"150984","vod_name":"武馆1981[电影解说]","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/ebd9aa59fc3737e44e5153d995b16018.jpg","vod_remarks":""},{"vod_id":"150983","vod_name":"名剑风流[电影解说]","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/4ae9fd2a5cce3d250538cbdb25af1ff3.jpg","vod_remarks":""},{"vod_id":"150982","vod_name":"山中传奇[电影解说]","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/8e07467bc178b17bd13b96774c84453d.jpg","vod_remarks":""},{"vod_id":"150981","vod_name":"少林门[电影解说]","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/ae2a7c03c89fe9cc1798f9b21c8b1255.jpg","vod_remarks":""},{"vod_id":"150980","vod_name":"无翼蝙蝠[电影解说]","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/1d91fa237a04bb566c86b63f16d97637.jpg","vod_remarks":""},{"vod_id":"150979","vod_name":"龙虎会风云[电影解说]","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/f33795e424f847e028af883b34c65670.jpg","vod_remarks":""},{"vod_id":"151010","vod_name":"WCBA 浙江稠州银行vs新疆天山20231026","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/f0b0f9fa8c3a7e6ff5f77383378fbba5.jpg","vod_remarks":""},{"vod_id":"151009","vod_name":"WCBA 四川远达美乐vs石家庄英励20231025","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/4ad19a026b4f03d2c3a7322dd7f1a29c.jpg","vod_remarks":""},{"vod_id":"151008","vod_name":"WCBA 陕西天泽vs河南垚鑫体育20231026","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/dd70e305ae15a78618d8c7bf65c81003.jpg","vod_remarks":""},{"vod_id":"151007","vod_name":"WCBA 山西竹叶青酒vs上海浦发银行20231026","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/bc15764504872b3358636e72f5373a9b.jpg","vod_remarks":""},{"vod_id":"151006","vod_name":"WCBA 内蒙古农信vs北京首钢首侨20231025","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/d928f128023cec310cf8dc4ea50f501d.jpg","vod_remarks":""},{"vod_id":"151005","vod_name":"WCBA 东莞新彤盛vs大庆安瑞达20231026","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/c947aade39b0b5ec6571b3ebcda152ad.jpg","vod_remarks":""},{"vod_id":"151004","vod_name":"CBA 浙江东阳光药vs浙江稠州金租20231114","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/d3ec88bdc9ac1cdcdb2537f684dfd586.png","vod_remarks":""},{"vod_id":"151003","vod_name":"CBA 浙江稠州金租vs天津先行者20231112","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/f891fb50f2e8c9bf924383cd4741fa69.png","vod_remarks":""},{"vod_id":"151002","vod_name":"CBA 新疆伊力特vs深圳马可波罗20231115","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/86847294034fe0b5a376eaf739838d10.png","vod_remarks":""},{"vod_id":"151001","vod_name":"CBA 四川金强vs九台农商银行20231115","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/822c1bbfd5922b7de4e0981cd0f505e2.png","vod_remarks":""},{"vod_id":"151000","vod_name":"CBA 山东高速vs深圳马可波罗20231112","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/84291a5dcc5995a3f4055a67e5069148.png","vod_remarks":""},{"vod_id":"150999","vod_name":"CBA 山东高速vs南京头排苏酒20231116","vod_pic":"https://img.lzzyimg.com/upload/vod/20231117-1/3735b540a919024387f4c375ff39dabd.png","vod_remarks":""}]
     * class : [{"type_name":"电影","type_id":"8"},{"type_name":"连续剧","type_id":"13"},{"type_name":"动漫","type_id":"28"},{"type_name":"综艺","type_id":"24"}]
     * filters : {"8":[{"key":"cateId","name":"类型","value":[]},{"key":"class","name":"按剧情","value":[{"n":"全部","v":""},{"n":"喜剧","v":"喜剧"},{"n":"爱情","v":"爱情"},{"n":"恐怖","v":"恐怖"},{"n":"动作","v":"动作"},{"n":"科幻","v":"科幻"},{"n":"动作","v":"动作"},{"n":"剧情","v":"剧情"},{"n":"战争","v":"战争"},{"n":"警匪","v":"警匪"},{"n":"犯罪","v":"犯罪"},{"n":"动画","v":"动画"},{"n":"奇幻","v":"奇幻"},{"n":"武侠","v":"武侠"},{"n":"冒险","v":"冒险"},{"n":"枪战","v":"枪战"},{"n":"恐怖","v":"恐怖"},{"n":"悬疑","v":"悬疑"},{"n":"惊悚","v":"惊悚"},{"n":"经典","v":"经典"},{"n":"青春","v":"青春"},{"n":"文艺","v":"文艺"},{"n":"微电影","v":"微电影"},{"n":"古装","v":"古装"},{"n":"历史","v":"历史"},{"n":"运动","v":"运动"},{"n":"农村","v":"农村"},{"n":"儿童","v":"儿童"},{"n":"网络电影","v":"网络电影"}]},{"key":"area","name":"地区","value":[{"n":"全部","v":""},{"n":"大陆","v":"大陆"},{"n":"香港","v":"香港"},{"n":"台湾","v":"台湾"},{"n":"美国","v":"美国"},{"n":"法国","v":"法国"},{"n":"英国","v":"英国"},{"n":"日本","v":"日本"},{"n":"韩国","v":"韩国"},{"n":"德国","v":"德国"},{"n":"泰国","v":"泰国"},{"n":"印度","v":"印度"},{"n":"意大利","v":"意大利"},{"n":"西班牙","v":"西班牙"},{"n":"加拿大","v":"加拿大"},{"n":"其他","v":"其他"}]},{"key":"year","name":"年份","value":[{"n":"全部","v":""},{"n":"2023","v":"2023"},{"n":"2022","v":"2022"},{"n":"2021","v":"2021"},{"n":"2020","v":"2020"},{"n":"2019","v":"2019"},{"n":"2018","v":"2018"},{"n":"2017","v":"2017"},{"n":"2016","v":"2016"},{"n":"2015","v":"2015"},{"n":"2014","v":"2014"},{"n":"2013","v":"2013"},{"n":"2012","v":"2012"},{"n":"2011","v":"2011"},{"n":"2010","v":"2010"}]},{"key":"lang","name":"语言","value":[{"n":"全部","v":""},{"n":"国语","v":"国语"},{"n":"英语","v":"英语"},{"n":"粤语","v":"粤语"},{"n":"闽南语","v":"闽南语"},{"n":"韩语","v":"韩语"},{"n":"日语","v":"日语"},{"n":"法语","v":"法语"},{"n":"德语","v":"德语"},{"n":"其它","v":"其它"}]},{"key":"letter","name":"按字母","value":[{"n":"全部","v":""},{"n":"A","v":"A"},{"n":"B","v":"B"},{"n":"C","v":"C"},{"n":"D","v":"D"},{"n":"E","v":"E"},{"n":"F","v":"F"},{"n":"G","v":"G"},{"n":"H","v":"H"},{"n":"I","v":"I"},{"n":"J","v":"J"},{"n":"K","v":"K"},{"n":"L","v":"L"},{"n":"M","v":"M"},{"n":"N","v":"N"},{"n":"O","v":"O"},{"n":"P","v":"P"},{"n":"Q","Q":"Q"},{"n":"R","v":"R"},{"n":"S","v":"S"},{"n":"T","v":"T"},{"n":"U","v":"U"},{"n":"V","v":"V"},{"n":"W","v":"W"},{"n":"X","X":"X"},{"n":"Y","v":"Y"},{"n":"Z","v":"Z"},{"n":"0-9","v":"0-9"}]},{"key":"by","name":"排序","value":[{"n":"按时间","v":"time"},{"n":"按人气","v":"hits"},{"n":"按评分","v":"score"}]}],"13":[{"key":"cateId","name":"类型","value":[]},{"key":"class","name":"按剧情","value":[{"n":"全部","v":""},{"n":"喜剧","v":"喜剧"},{"n":"爱情","v":"爱情"},{"n":"恐怖","v":"恐怖"},{"n":"动作","v":"动作"},{"n":"科幻","v":"科幻"},{"n":"动作","v":"动作"},{"n":"剧情","v":"剧情"},{"n":"战争","v":"战争"},{"n":"警匪","v":"警匪"},{"n":"犯罪","v":"犯罪"},{"n":"动画","v":"动画"},{"n":"奇幻","v":"奇幻"},{"n":"武侠","v":"武侠"},{"n":"冒险","v":"冒险"},{"n":"枪战","v":"枪战"},{"n":"恐怖","v":"恐怖"},{"n":"悬疑","v":"悬疑"},{"n":"惊悚","v":"惊悚"},{"n":"经典","v":"经典"},{"n":"青春","v":"青春"},{"n":"文艺","v":"文艺"},{"n":"微电影","v":"微电影"},{"n":"古装","v":"古装"},{"n":"历史","v":"历史"},{"n":"运动","v":"运动"},{"n":"农村","v":"农村"},{"n":"儿童","v":"儿童"},{"n":"网络电影","v":"网络电影"}]},{"key":"area","name":"地区","value":[{"n":"全部","v":""},{"n":"大陆","v":"大陆"},{"n":"香港","v":"香港"},{"n":"台湾","v":"台湾"},{"n":"美国","v":"美国"},{"n":"法国","v":"法国"},{"n":"英国","v":"英国"},{"n":"日本","v":"日本"},{"n":"韩国","v":"韩国"},{"n":"德国","v":"德国"},{"n":"泰国","v":"泰国"},{"n":"印度","v":"印度"},{"n":"意大利","v":"意大利"},{"n":"西班牙","v":"西班牙"},{"n":"加拿大","v":"加拿大"},{"n":"其他","v":"其他"}]},{"key":"year","name":"年份","value":[{"n":"全部","v":""},{"n":"2023","v":"2023"},{"n":"2022","v":"2022"},{"n":"2021","v":"2021"},{"n":"2020","v":"2020"},{"n":"2019","v":"2019"},{"n":"2018","v":"2018"},{"n":"2017","v":"2017"},{"n":"2016","v":"2016"},{"n":"2015","v":"2015"},{"n":"2014","v":"2014"},{"n":"2013","v":"2013"},{"n":"2012","v":"2012"},{"n":"2011","v":"2011"},{"n":"2010","v":"2010"}]},{"key":"lang","name":"语言","value":[{"n":"全部","v":""},{"n":"国语","v":"国语"},{"n":"英语","v":"英语"},{"n":"粤语","v":"粤语"},{"n":"闽南语","v":"闽南语"},{"n":"韩语","v":"韩语"},{"n":"日语","v":"日语"},{"n":"法语","v":"法语"},{"n":"德语","v":"德语"},{"n":"其它","v":"其它"}]},{"key":"letter","name":"按字母","value":[{"n":"全部","v":""},{"n":"A","v":"A"},{"n":"B","v":"B"},{"n":"C","v":"C"},{"n":"D","v":"D"},{"n":"E","v":"E"},{"n":"F","v":"F"},{"n":"G","v":"G"},{"n":"H","v":"H"},{"n":"I","v":"I"},{"n":"J","v":"J"},{"n":"K","v":"K"},{"n":"L","v":"L"},{"n":"M","v":"M"},{"n":"N","v":"N"},{"n":"O","v":"O"},{"n":"P","v":"P"},{"n":"Q","Q":"Q"},{"n":"R","v":"R"},{"n":"S","v":"S"},{"n":"T","v":"T"},{"n":"U","v":"U"},{"n":"V","v":"V"},{"n":"W","v":"W"},{"n":"X","X":"X"},{"n":"Y","v":"Y"},{"n":"Z","v":"Z"},{"n":"0-9","v":"0-9"}]},{"key":"by","name":"排序","value":[{"n":"按时间","v":"time"},{"n":"按人气","v":"hits"},{"n":"按评分","v":"score"}]}],"24":[{"key":"cateId","name":"类型","value":[]},{"key":"class","name":"按剧情","value":[{"n":"全部","v":""},{"n":"体育","v":"体育"},{"n":"选秀","v":"选秀"},{"n":"情感","v":"情感"},{"n":"访谈","v":"访谈"},{"n":"音乐","v":"音乐"},{"n":"旅游","v":"旅游"},{"n":"美食","v":"美食"},{"n":"纪实","v":"纪实"},{"n":"搞笑","v":"搞笑"},{"n":"曲艺","v":"曲艺"},{"n":"生活","v":"生活"},{"n":"游戏互动","v":"游戏互动"},{"n":"财经","v":"财经"},{"n":"求职","v":"求职"}]},{"key":"area","name":"地区","value":[{"n":"全部","v":""},{"n":"内地","v":"内地"},{"n":"港台","v":"港台"},{"n":"日韩","v":"日韩"},{"n":"欧美","v":"欧美"}]},{"key":"year","name":"年份","value":[{"n":"全部","v":""},{"n":"2023","v":"2023"},{"n":"2022","v":"2022"},{"n":"2021","v":"2021"},{"n":"2020","v":"2020"},{"n":"2019","v":"2019"},{"n":"2018","v":"2018"},{"n":"2017","v":"2017"},{"n":"2016","v":"2016"},{"n":"2015","v":"2015"},{"n":"2014","v":"2014"},{"n":"2013","v":"2013"},{"n":"2012","v":"2012"},{"n":"2011","v":"2011"},{"n":"2010","v":"2010"}]},{"key":"lang","name":"语言","value":[{"n":"全部","v":""},{"n":"国语","v":"国语"},{"n":"英语","v":"英语"},{"n":"粤语","v":"粤语"},{"n":"闽南语","v":"闽南语"},{"n":"韩语","v":"韩语"},{"n":"日语","v":"日语"},{"n":"其它","v":"其它"}]},{"key":"letter","name":"按字母","value":[{"n":"全部","v":""},{"n":"A","v":"A"},{"n":"B","v":"B"},{"n":"C","v":"C"},{"n":"D","v":"D"},{"n":"E","v":"E"},{"n":"F","v":"F"},{"n":"G","v":"G"},{"n":"H","v":"H"},{"n":"I","v":"I"},{"n":"J","v":"J"},{"n":"K","v":"K"},{"n":"L","v":"L"},{"n":"M","v":"M"},{"n":"N","v":"N"},{"n":"O","v":"O"},{"n":"P","v":"P"},{"n":"Q","Q":"Q"},{"n":"R","v":"R"},{"n":"S","v":"S"},{"n":"T","v":"T"},{"n":"U","v":"U"},{"n":"V","v":"V"},{"n":"W","v":"W"},{"n":"X","X":"X"},{"n":"Y","v":"Y"},{"n":"Z","v":"Z"},{"n":"0-9","v":"0-9"}]},{"key":"by","name":"排序","value":[{"n":"按时间","v":"time"},{"n":"按人气","v":"hits"},{"n":"按评分","v":"score"}]}],"28":[{"key":"cateId","name":"类型","value":[]},{"key":"class","name":"按剧情","value":[{"n":"全部","v":""},{"n":"校园","v":"校园"},{"n":"科幻","v":"科幻"},{"n":"热血","v":"热血"},{"n":"推理","v":"推理"},{"n":"搞笑","v":"搞笑"},{"n":"情感","v":"情感"},{"n":"冒险","v":"冒险"},{"n":"萝莉","v":"萝莉"},{"n":"恋爱","v":"恋爱"},{"n":"动作","v":"动作"},{"n":"机战","v":"机战"},{"n":"运动","v":"运动"},{"n":"战争","v":"战争"},{"n":"少年","v":"少年"},{"n":"少女","v":"少女"},{"n":"社会","v":"社会"},{"n":"原创","v":"原创"},{"n":"亲子","v":"亲子"},{"n":"益智","v":"益智"},{"n":"励志","v":"励志"},{"n":"其他","v":"其他"}]},{"key":"area","name":"地区","value":[{"n":"全部","v":""},{"n":"国产","v":"国产"},{"n":"日本","v":"日本"},{"n":"欧美","v":"欧美"},{"n":"其他","v":"其他"}]},{"key":"year","name":"年份","value":[{"n":"全部","v":""},{"n":"2023","v":"2023"},{"n":"2022","v":"2022"},{"n":"2021","v":"2021"},{"n":"2020","v":"2020"},{"n":"2019","v":"2019"},{"n":"2018","v":"2018"},{"n":"2017","v":"2017"},{"n":"2016","v":"2016"},{"n":"2015","v":"2015"},{"n":"2014","v":"2014"},{"n":"2013","v":"2013"},{"n":"2012","v":"2012"},{"n":"2011","v":"2011"},{"n":"2010","v":"2010"}]},{"key":"lang","name":"语言","value":[{"n":"全部","v":""},{"n":"国语","v":"国语"},{"n":"英语","v":"英语"},{"n":"粤语","v":"粤语"},{"n":"闽南语","v":"闽南语"},{"n":"韩语","v":"韩语"},{"n":"日语","v":"日语"},{"n":"其它","v":"其它"}]},{"key":"letter","name":"按字母","value":[{"n":"全部","v":""},{"n":"A","v":"A"},{"n":"B","v":"B"},{"n":"C","v":"C"},{"n":"D","v":"D"},{"n":"E","v":"E"},{"n":"F","v":"F"},{"n":"G","v":"G"},{"n":"H","v":"H"},{"n":"I","v":"I"},{"n":"J","v":"J"},{"n":"K","v":"K"},{"n":"L","v":"L"},{"n":"M","v":"M"},{"n":"N","v":"N"},{"n":"O","v":"O"},{"n":"P","v":"P"},{"n":"Q","Q":"Q"},{"n":"R","v":"R"},{"n":"S","v":"S"},{"n":"T","v":"T"},{"n":"U","v":"U"},{"n":"V","v":"V"},{"n":"W","v":"W"},{"n":"X","X":"X"},{"n":"Y","v":"Y"},{"n":"Z","v":"Z"},{"n":"0-9","v":"0-9"}]},{"key":"by","name":"排序","value":[{"n":"按时间","v":"time"},{"n":"按人气","v":"hits"},{"n":"按评分","v":"score"}]}]}
     */

    private FiltersBean filters;
    private List<ListBean> list;
    @SerializedName("class")
    private List<ClassBean> classX;

    public FiltersBean getFilters() {
        return filters;
    }

    public void setFilters(FiltersBean filters) {
        this.filters = filters;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public List<ClassBean> getClassX() {
        return classX;
    }

    public void setClassX(List<ClassBean> classX) {
        this.classX = classX;
    }

    public static class FiltersBean {
        public ArrayList<SortFilter> filters = new ArrayList<>();

        public ArrayList<SortFilter> getFilters() {
            return filters;
        }

        public void setFilters(ArrayList<SortFilter> filters) {
            this.filters = filters;
        }
    }

    public static class ListBean {
        /**
         * vod_id : 151064
         * vod_name : 绑架2023
         * vod_pic : https://img.lzzyimg.com/upload/vod/20231118-1/68693ae573c4f9303e762d8ab0ae1074.jpg
         * vod_remarks :
         */

        private String vod_id;
        private String vod_name;
        private String vod_pic;
        private String vod_remarks;

        public String getVod_id() {
            return vod_id;
        }

        public void setVod_id(String vod_id) {
            this.vod_id = vod_id;
        }

        public String getVod_name() {
            return vod_name;
        }

        public void setVod_name(String vod_name) {
            this.vod_name = vod_name;
        }

        public String getVod_pic() {
            return vod_pic;
        }

        public void setVod_pic(String vod_pic) {
            this.vod_pic = vod_pic;
        }

        public String getVod_remarks() {
            return vod_remarks;
        }

        public void setVod_remarks(String vod_remarks) {
            this.vod_remarks = vod_remarks;
        }
    }

    public static class ClassBean {
        /**
         * type_name : 电影
         * type_id : 8
         */

        private String type_name;
        private String type_id;
        public ArrayList<SortFilter> filters = new ArrayList<>();
        public HashMap<String, String> filterSelect = new HashMap<>();

        public ArrayList<SortFilter> getFilters() {
            return filters;
        }

        public void setFilters(ArrayList<SortFilter> filters) {
            this.filters = filters;
        }

        public String getType_name() {
            return type_name;
        }

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }

        public String getType_id() {
            return type_id;
        }

        public void setType_id(String type_id) {
            this.type_id = type_id;
        }
    }
}
