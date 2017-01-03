<!DOCTYPE html>
<html>
<head>
    <title></title>
    <script>

        var smartPhones = [
            'iphone', 'ipod',
            'windows ce',
            'android', 'blackberry',
            'nokia', 'webos',
            'opera mini', 'sonyerricsson',
            'opera mobi', 'iemobile'
        ];

        for (var i in smartPhones) {
          
            if (navigator.userAgent.toLowerCase().match(new RegExp(smartPhones[i]))) {
                alert('This is Smart Phone..!');
                document.location = '../pan/mobile/home.jsp';
            }else if (!(navigator.userAgent.toLowerCase().match(new RegExp(smartPhones[i])))) 
            	document.location = '../pan/Main/index.jsp';
        }
    </script>
</head>
<body>

</body>
</html>
