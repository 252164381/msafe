<p>网站防爬虫、防机器操作、防SQL注入、信息加密一站式部署。</p>
<p>先在<a href='https://msafe.top'>https://msafe.top</a>提交绑定域名、邮箱信息</p>
<h2>配置流程:</h2>
                        <div class="step">
                            <strong>第一步:</strong> 在您的网站共通页面部分,引入JS代码
                            <pre><code>&lt;script&gt;var msign_key = '&lt;公钥&gt;';&lt;/script&gt;
&lt;script src="&lt;安全JS链接&gt;" &gt;&lt;/script&gt;</code></pre>
                        </div>
                        <div class="step">
                            <strong>第二步:</strong> 在安装Docker环境中，拉取Nginx镜像
                            <pre><code>docker pull 252164381/msafe</code></pre>
                        </div>
                        <div class="step">
                            <strong>第三步:</strong> 运行Nginx镜像
                            <pre><code>docker run -d -p &lt;代理访问端口&gt;:81 --name msafe --restart=always -e PROXY_PASS="&lt;网站IP+端口&gt;" -e PASSWORD=&lt;私钥&gt; 252164381/msafe</code></pre>
                        </div>
                        <p>PROXY_PASS默认值:http://127.0.0.1:80</p>
                        <p>完成以上配置，网站可抵御大部分攻击。</p>
<p></p>
<h2>关键信息加密:</h2>
                        <div class="step">
                            <strong>第一步:</strong> 后端将关键信息XOR(key为私钥)、Base64编码
                            <pre><code>import java.util.Base64;
public class XORBase64 {
    // 定义 XOR 加密函数
    public static String xorEncrypt(String input, String key) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            encrypted.append((char) (input.charAt(i) ^ key.charAt(i % key.length())));
        }
        return encrypted.toString();
    }
    public static void main(String[] args) {
        // 要加密的原始字符串
        String originalString = "Hello, world!";
        // 密钥
        String key = "<私钥>";
        // 对原始字符串进行 XOR 加密
        String encryptedString = xorEncrypt(originalString, key);
        System.out.println("Encrypted: " + encryptedString);
        // 将加密后的字符串进行 Base64 编码
        String base64EncodedString = Base64.getEncoder().encodeToString(encryptedString.getBytes());
        System.out.println("Base64 Encoded: " + base64EncodedString);
    }
}
</code></pre>
                        </div>
                        </div>
                        <div class="step">
                            <strong>第二步:</strong> 前端调用mSafe.decode方法解码
                            <pre><code>mSafe.decode(data.message)</code></pre>
                        </div>
<h2>邀请码(不定期发放):</h2>
<pre><code>5fca243da6e11791fb7d7e61a8c6b926
76f1083b4841cc71e7365d6f073ffedf
d72006666c7d629a7714938bf94fe140
459513b6c7fa54f3e21464df1ae635f6
51ecf14ff6614bf6f3191cde257d7d9c
d1372c648e86bd01e7c32c38129ad5ca
0beb450d7127cd29d16437d74dd8e92c
16457d0ea2fb1fbc5a96a4168feb5504
a333b04bad5d52ec01b904f26ab70c94
59f74bcf12f946e9a519c9fa6814ca81
9e07fb038cfd09e055a9f77e5d555ce8
</code></pre>
