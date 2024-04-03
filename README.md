<p>先在<a href='https://msafe.top'>https://msafe.top</a>提交绑定域名、邮箱信息</p>
<p>配置流程:</p>
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
                        <p>完成以上配置，您的网站可抵御大部分攻击。</p>
