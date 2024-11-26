<?php
$errname = "";
$errage = "";
$errmobile = "";

if (isset($_POST["ac"]) && $_POST["ac"] == "login") {

    if (!preg_match('/^[A-Z][a-zA-Z -]+$/', $_POST["name"])) {
        $errname = '<p class="errText">Please enter your full name </p>';
    }

    if (!preg_match('/^\d{1,2}$/', $_POST["age"])) {
        $errage = '<p class="errText">Age must be 1 or 2 digits</p>';
    }

    if (!preg_match("/^\d{3}-\d{7}$/", $_POST["mobile"])) {
        $errmobile = '<p class="errText">Mobile must be in this format: 050-0000000</p>';
    }

    if (empty($errname) && empty($errage) && empty($errmobile)) {
        $connect = mysqli_connect("localhost", "root", "", "career_system");
        if (!$connect) {
            die("Error, check your server connection: " . mysqli_connect_error()); 
        }

        $v_name = mysqli_real_escape_string($connect, $_POST['name']);
        $v_age = (int)$_POST['age'];
        $v_gender = mysqli_real_escape_string($connect, $_POST['gender']);
        $v_mobile = mysqli_real_escape_string($connect, $_POST['mobile']);

        $query = "INSERT INTO applicant (name, age, gender, mobile) VALUES ('$v_name', $v_age, '$v_gender', '$v_mobile')";
        $result = mysqli_query($connect, $query);

        if ($result) {
            echo "Your information has been received";
        } else {
            echo "Error: " . mysqli_error($connect); 
        }

        mysqli_close($connect);
    }
}
?>

<html>
<head>
<title>PHP Form Validation</title>
</head>
<body>
<div align="center">
    <p> </p>
    <h2>PHP Form Validation Example</h2>
    <form name="form1" action="<?php echo $_SERVER['PHP_SELF']; ?>" method="POST">  
        <input type="hidden" name="ac" value="login">
        <table width="485" border="0">
            <tr>
                <td width="48">Full Name*</td>
                <td width="427"><input name="name" type="text" id="name" value="<?php echo isset($_POST["name"]) ? $_POST["name"] : ''; ?>">
                <?php if(isset($errname)) echo $errname; ?></td>
            </tr>
            <tr>
                <td>Age*</td>
                <td><input name="age" type="text" id="age" value="<?php echo isset($_POST["age"]) ? $_POST["age"] : ''; ?>">
                <?php if(isset($errage)) echo $errage; ?></td>
            </tr>
            <tr>
                <td>Gender*</td>
                <td>
                    <input name="gender" type="radio" value="Male" <?php if(isset($_POST['gender']) && $_POST['gender']=="Male") echo "checked";?>>Male
                    <input name="gender" type="radio" value="Female" <?php if(isset($_POST['gender']) && $_POST['gender']=="Female") echo "checked";?>>Female
                </td>
            </tr>
            <tr>
                <td>Mobile*</td>
                <td><input name="mobile" type="text" id="mobile" value="<?php echo isset($_POST["mobile"]) ? $_POST["mobile"] : ''; ?>">
                <?php if(isset($errmobile)) echo $errmobile; ?></td>
            </tr>
            <tr>
                <td> </td>
                <td><input type="submit" name="Submit" value="Submit">
                <input name="reset" type="reset" id="reset" value="Reset"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>