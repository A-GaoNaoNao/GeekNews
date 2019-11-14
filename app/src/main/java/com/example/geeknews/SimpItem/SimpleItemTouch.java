package com.example.geeknews.SimpItem;

import com.example.geeknews.jiekou.ItemCallBack;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleItemTouch extends ItemTouchHelper.Callback {

    private ItemCallBack itemCallBack;
    private boolean mIsEnable;

    public SimpleItemTouch(ItemCallBack itemCallBack) {
        this.itemCallBack = itemCallBack;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int drag_flag = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swip_flag = ItemTouchHelper.LEFT;
        return makeMovementFlags(drag_flag,swip_flag);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        itemCallBack.moveItem(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        itemCallBack.deleteItem(viewHolder.getAdapterPosition());
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return super.isLongPressDragEnabled();
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return super.isItemViewSwipeEnabled();
    }
    public void setItemIsSwip(boolean isEnable){
        this.mIsEnable = isEnable;
    }
}
