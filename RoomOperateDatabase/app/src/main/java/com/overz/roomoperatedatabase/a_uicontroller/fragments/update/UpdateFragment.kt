package com.overz.roomoperatedatabase.a_uicontroller.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.overz.roomoperatedatabase.R
import com.overz.roomoperatedatabase.d_model.User
import com.overz.roomoperatedatabase.b_viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.updateFirstName_et.setText(args.currentUser.firstName)
        view.updateLastName_et.setText(args.currentUser.lastName)
        view.updateAge_et.setText(args.currentUser.age.toString())
        if (args.currentUser.sex) {
            view.update_sex_male.isChecked = true
        } else {
            view.update_sex_female.isChecked = true
        }


        view.update_btn.setOnClickListener {
            updateItem()
        }

        //添加菜单
        setHasOptionsMenu(true)

        return view
    }

    //更新数据库中的数据
    private fun updateItem() {
        val firstName = updateFirstName_et.text.toString()
        val lastName = updateLastName_et.text.toString()
        val age = Integer.parseInt(updateAge_et.text.toString())
        val sex = update_sex_male.isChecked
        if (inputCheck(firstName, lastName, updateAge_et.text)) {
            // Create User Object
            val updateUser = User(args.currentUser.id, firstName, lastName, age, sex)
            //Update current User
            mUserViewModel.updateUser(updateUser)
            Toast.makeText(requireContext(), "更新成功！", Toast.LENGTH_SHORT).show()
            //Navigate Back 导航返回List Fragment
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)

        } else {
            Toast.makeText(requireContext(), "请填写完整", Toast.LENGTH_SHORT).show()
        }
    }

    //检查输入的信息是否为空
    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.menu_delete) {
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }
    //删除用户
    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("YES") { _, _ ->

            mUserViewModel.deleteUser(args.currentUser)
            Toast.makeText(requireContext(),"成功删除${args.currentUser.firstName}",Toast.LENGTH_SHORT).show()
            //Navigate Back 导航返回List Fragment
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)


        }
        builder.setNegativeButton("NO") { _, _ ->


            Toast.makeText(requireContext(),"取消删除${args.currentUser.firstName}",Toast.LENGTH_SHORT).show()
        }
        builder.setTitle("Delete ${args.currentUser.firstName}?")
        builder.setMessage("Are you sure to delete ${args.currentUser.firstName}?")
        builder.create().show()
    }

}