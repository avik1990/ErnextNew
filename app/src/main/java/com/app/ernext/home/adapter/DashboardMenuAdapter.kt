package com.app.ernext.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.ernext.R
import com.app.ernext.home.DashboardModel

class DashboardMenuAdapter(private val mContext: Context, private val expenseList: List<DashboardModel.CatRow>?, private val getIdFromMenuAdapter: GetIdFromMenuAdapter): RecyclerView.Adapter<DashboardMenuAdapter.MyViewHolder>() {

    interface GetIdFromMenuAdapter {
        fun returnedID(id: String?)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvMenuText: TextView
        var child_container: RelativeLayout

        init {
            tvMenuText = view.findViewById(R.id.tvMenuText) as com.app.ernext.customUiComponents.QuicksandMediumTextview
            child_container = view.findViewById(R.id.child_container)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return expenseList!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvMenuText.setText(expenseList!![position].catName)
        holder.child_container.setOnClickListener(View.OnClickListener {
            getIdFromMenuAdapter.returnedID(expenseList!![position].catId!!) })
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

   /* fun onBindViewHolder(holder: com.customdrawer.app.adpater.MenuAdapterWOM.MyViewHolder, position: Int) {
        val c: MenuItems = expenseListFilter[position]
        holder.tvMenuText.setText(c.getItemName())
        holder.child_container.setOnClickListener(View.OnClickListener { getIdFromMenuAdapter.returnedID(c.getId()) })
    }

    override fun getItemCount(): Int {
        return expenseListFilter.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): com.customdrawer.app.adpater.MenuAdapterWOM.MyViewHolder? {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return com.customdrawer.app.adpater.MenuAdapterWOM.MyViewHolder(v)
    }*/
}