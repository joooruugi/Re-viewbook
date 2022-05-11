<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/main/opening.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/all/all.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <title>RVB</title>
    <style>
        html {
            width: 100%;
            height: 100%;
        }
    </style>
</head>

<body>
   
    <div class="opening">
        <p class="fontimportant">교육용으로 제작된 홈페이지입니다.</p>
        <p class="fontimportant">교육용이지만, 실제 홈페이지처럼 즐겨주세요.</p>
        <p class="fontimportant2">하단 명함을 누르면 홈페이지로 이동됩니다.</p>
       
    </div>
    <canvas></canvas>

    <div class="opening_img">
        <a href="<%=request.getContextPath() %>/main"><img class="opening_img1" src="<%=request.getContextPath() %>/resources/image/main/rvb명함앞.png"></a>
        <a href="<%=request.getContextPath() %>/main"><img class="opening_img2" src="<%=request.getContextPath() %>/resources/image/main/rvb명함뒤.png"></a>
    </div>
    <script>
        const canvas = document.querySelector('canvas')
        canvas.width = window.innerWidth
        canvas.height = window.innerHeight
        const ctx = canvas.getContext('2d')

        const TOTAL = 100
        const petalArray = []

        const petalImg = new Image()
        petalImg.src = '<%=request.getContextPath() %>/resources/image/main/petal.png'
        petalImg.addEventListener('load', () => {
            for (let i = 0; i < TOTAL; i++) {
                petalArray.push(new Petal())
            }
            render()
        })

        function render() {
            ctx.clearRect(0, 0, canvas.width, canvas.height)
            petalArray.forEach(petal => petal.animate())
            window.requestAnimationFrame(render)
        }

        window.addEventListener('resize', () => {
            canvas.width = window.innerWidth
            canvas.height = window.innerHeight
        })


        // Petal class
        class Petal {
            constructor() {
                this.x = Math.random() * canvas.width
                this.y = (Math.random() * canvas.height * 2) - canvas.height
                this.w = 25 + Math.random() * 15
                this.h = 20 + Math.random() * 10
                this.opacity = this.w / 40
                this.flip = Math.random()

                this.xSpeed = 1.5 + Math.random() * 1
                this.ySpeed = 1 + Math.random() * 0.5
                this.flipSpeed = Math.random() * 0.03
            }

            draw() {
                if (this.y > canvas.height || this.x > canvas.width) {
                    this.x = -petalImg.width
                    this.y = (Math.random() * canvas.height * 2) - canvas.height
                    this.xSpeed = 1.5 + Math.random() * 1
                    this.ySpeed = 1 + Math.random() * 0.5
                    this.flip = Math.random()
                }
                ctx.globalAlpha = this.opacity
                ctx.drawImage(
                    petalImg,
                    this.x,
                    this.y,
                    this.w * (0.6 + (Math.abs(Math.cos(this.flip)) / 3)),
                    this.h * (0.8 + (Math.abs(Math.sin(this.flip)) / 5))
                )
            }

            animate() {
                this.x += this.xSpeed
                this.y += this.ySpeed
                this.flip += this.flipSpeed
                this.draw()
            }
        }
    </script>
</body>

</html>