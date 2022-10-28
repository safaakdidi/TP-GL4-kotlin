package com.gl4.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class PizzaOrder : AppCompatActivity() {


lateinit var dropDownSizetxt:AutoCompleteTextView

lateinit var dropDownTypetxt:AutoCompleteTextView
lateinit var txtName:TextInputEditText
    lateinit var txtLastName:TextInputEditText
    lateinit var txtPhone:TextInputEditText
    lateinit var txtAddress:TextInputEditText
    lateinit var txtEmail:TextInputEditText

    lateinit var orderBtn:Button
    lateinit var txtNameLayout: TextInputLayout
    lateinit var txtLastNameLayout: TextInputLayout
    lateinit var txtPhoneLayout: TextInputLayout
    lateinit var txtAddressLayout: TextInputLayout
    lateinit var txtEmailLayout: TextInputLayout
    lateinit var txtTypeLayout: TextInputLayout
    lateinit var txtSizeLayout: TextInputLayout




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_order)

txtNameLayout=findViewById(R.id.textNameInputLayout)
        txtLastNameLayout=findViewById(R.id.textNameInputLayout)
        txtPhoneLayout=findViewById(R.id.textNameInputLayout)
        txtAddressLayout=findViewById(R.id.textNameInputLayout)
        txtEmailLayout=findViewById(R.id.textNameInputLayout)
        txtTypeLayout=findViewById(R.id.textNameInputLayout)
        txtSizeLayout=findViewById(R.id.textNameInputLayout)
        dropDownSizetxt=findViewById(R.id.autoCompleteSizeField)
        dropDownTypetxt=findViewById(R.id.autoCompleteTypeField)
        txtName=findViewById(R.id.textNameField)
        txtLastName=findViewById(R.id.textLastNameField)
        txtPhone=findViewById(R.id.textPhoneField)
        txtAddress=findViewById(R.id.textAddressField)
        txtEmail=findViewById(R.id.textEmailField)
        orderBtn=findViewById(R.id.orderBtn)

        val sizes= arrayOf( "Moyenne", "Mini", "Maxi");
        val sizeAdapter =ArrayAdapter(
            this,
            R.layout.dropdown_item,
            sizes
        );
dropDownSizetxt.setAdapter(sizeAdapter);
        val types= arrayOf("Margarita","Peperoni","Vegetarian","Mexican");
        val typeAdapter=ArrayAdapter(
            this,
            R.layout.dropdown_item,
        types);
        dropDownTypetxt.setAdapter(typeAdapter)
        orderBtn.setOnClickListener { view ->
if(TextUtils.isEmpty(txtName.text.toString())){
    txtNameLayout.error="Enter Name"
}else if(TextUtils.isEmpty(txtLastName.text.toString())){
    txtNameLayout.isErrorEnabled=false
    txtLastNameLayout.error="Enter Last Name"
}else if(TextUtils.isEmpty(txtPhone.text.toString())){
    txtLastNameLayout.isErrorEnabled=false
    txtPhoneLayout.error="Enter Phone Number"
}else if(TextUtils.isEmpty(txtAddress.text.toString())){
    txtPhoneLayout.isErrorEnabled=false
    txtAddressLayout.error="Enter Addrass"
}else if(TextUtils.isEmpty(dropDownSizetxt.text.toString())){
    txtAddressLayout.isErrorEnabled=false
    txtSizeLayout.error="Choose Size"
}else if(TextUtils.isEmpty(dropDownTypetxt.text.toString())){
    txtSizeLayout.isErrorEnabled=false
    txtTypeLayout.error="Choose Type"
}else if(TextUtils.isEmpty(txtEmail.text.toString())){
    txtTypeLayout.isErrorEnabled=false
    txtEmailLayout.error="Enter Email"
}else{
    val name=txtName.text.toString()
    val lst=txtLastName.text.toString()
    val phone=txtPhone.text.toString()
    val addr=txtAddress.text.toString()
    val size=dropDownSizetxt.text.toString()
    val type=dropDownTypetxt.text.toString()
    val email=txtEmail.text.toString()
val subject="Pizza Order"
    val msg="Mr(s) $name $lst ordered a $size $type Pizza to $addr.You can call her(him) using this number:$phone"

    val intent=Intent(Intent.ACTION_SENDTO).apply {
        data= Uri.parse("mailto")
        setType("message/rfc822")
        putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        putExtra(Intent.EXTRA_SUBJECT,subject)
        putExtra(Intent.EXTRA_TEXT,msg)
    }
//    if(intent.resolveActivity(packageManager)!=null){
//        startActivity(Intent.createChooser(intent,"Choose Email Client...."))
//    }else{
//        Toast.makeText(this,"Required App is not installed",Toast.LENGTH_SHORT).show()
//    }
    try {
        //start email intent
        startActivity(Intent.createChooser(intent, "Choose Email Client..."))
    }
    catch (e: Exception){
        //if any thing goes wrong for example no email client application or any exception
        //get and show exception message
        Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
    }
}
        }
    }


}