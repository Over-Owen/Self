package com.overz.list_view.baseAdapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.overz.list_view_recycler_view.R
import java.util.*


/**
 * 根据准备好的数据源和子项布局完成ListView效果的一一设置
 * 做一些细节处理
 */
class MyBaseAdapter(list: List<Msg>, ctx: Context) :
    BaseAdapter() {
    private var list: List<Msg> = ArrayList()
    private val ctx: Context

    //获取数量  设置ListView的长度
    override fun getCount(): Int {
        return list.size
    }

    //获取当前view视图    设置ListView每一项的显示效果 --- 每个视图出现时都会执行
    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
        //完成对View的设置
        //将布局资源 转为 View
        //参数1：所要引用的布局资源

        //优化2 ViewHolder
        var convertView = convertView
        val holder: ViewHolder

        //优化1 利用进入RecycleBin中的convertView 减少对convertView的赋值
        //现在 convertView的运行机制像一个RecycleBin，回收站一样，不在视图中显示时就缓存
        if (convertView == null) {
            Log.e("TAG", "View 视图$position")
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item3, null)
            holder = ViewHolder()
            holder.avatar = convertView.findViewById(R.id.user_avatar)
            holder.nickName = convertView.findViewById(R.id.user_nick_name)
            holder.date = convertView.findViewById(R.id.publish_time)
            holder.content = convertView.findViewById(R.id.publish_content)
            holder.isLike = convertView.findViewById(R.id.publish_like)
            holder.comment = convertView.findViewById(R.id.publish_comment)
            holder.repost = convertView.findViewById(R.id.publish_repost)
            convertView.tag = holder
        } else {

            //通过getTag()取出ViewHolder对象，然后直接通过holder空间方式在外面直接操作控件，从而避免大幅度使用findById操作。
            //事实上getTag效率云远大于findById操作。
            holder = convertView.tag as ViewHolder
        }
        val m = list[position]


        //头像
//        ImageView avatar = convertView.findViewById(R.id.user_avatar);
        holder.avatar!!.setImageResource(m.avatar)
        //昵称
//        TextView nickName = convertView.findViewById(R.id.user_nick_name);
        holder.nickName?.setText(m.nickName)
        //时间
//        TextView date = convertView.findViewById(R.id.publish_time);
        holder.date?.setText(m.date)
        //内容
//        TextView content = convertView.findViewById(R.id.publish_content);
        holder.content?.setText(m.content)
        //是否点赞
//        ImageView isLike = convertView.findViewById(R.id.publish_like);
        if (m.isLike) {
            holder.isLike!!.setImageResource(R.drawable.heart_yes)
        } else {
            holder.isLike!!.setImageResource(R.drawable.heart_no)
        }
        holder.isLike!!.setOnClickListener { v: View? ->
            if (m.isLike) {
                holder.isLike!!.setImageResource(R.drawable.heart_no)
            } else {
                holder.isLike!!.setImageResource(R.drawable.heart_yes)
            }
        }
        //评论 点击事件
//        ImageView comment = convertView.findViewById(R.id.publish_comment);
        holder.comment!!.setOnClickListener { v: View? ->
            Toast.makeText(
                ctx,
                "点击评论",
                Toast.LENGTH_SHORT
            ).show()
        }
        //转发
        //评论 点击事件
//        ImageView repost = convertView.findViewById(R.id.publish_repost);
        holder.repost!!.setOnClickListener { v: View? ->
            Toast.makeText(
                ctx,
                "点击转发",
                Toast.LENGTH_SHORT
            ).show()
        }
        return convertView
    }

    //获取某一项
    override fun getItem(position: Int): Any? {
        return null
    }

    //获取item的id
    override fun getItemId(position: Int): Long {
        return 0
    }

    //1. 自定义一个类  叫ViewHolder
    internal class ViewHolder {
        //2. 将需要保存的视图声明为公开的属性
        var avatar: ImageView? = null
        var isLike: ImageView? = null
        var comment: ImageView? = null
        var repost: ImageView? = null
        var nickName: TextView? = null
        var date: TextView? = null
        var content: TextView? = null //3. 什么时候保存，当convertView为空时完成对ViewHolder的实例化工作并为为各个控件属性赋值
        //4. 什么时候用  所有时间都要用，     性能提升是在convertView不为null时体现
        //5.怎么用     当convertView为null时，完成了ViewHolder及内部控件属性的初始化工作后，调用一句代码
        //convertView.setTag(holder);
        //当convertView不为空时，  holder = convertView.getTag();
    }

    init {
        this.list = list
        this.ctx = ctx
    }
}
