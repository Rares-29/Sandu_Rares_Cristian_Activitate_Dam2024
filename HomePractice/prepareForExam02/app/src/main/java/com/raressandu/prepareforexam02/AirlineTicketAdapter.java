package com.raressandu.prepareforexam02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AirlineTicketAdapter extends BaseAdapter {


    ArrayList<AirlineTicket> tickets;
    Context ctx;
    Integer templateId;

    public AirlineTicketAdapter(ArrayList<AirlineTicket> tickets, Context ctx, Integer templateId) {
        this.tickets = tickets;
        this.ctx = ctx;
        this.templateId = templateId;
    }

    @Override
    public int getCount() {
        return tickets.size();
    }

    @Override
    public Object getItem(int i) {
        return tickets.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(templateId, viewGroup, false);
        TextView passengerName = v.findViewById(R.id.templatePassengerName);
        TextView price = v.findViewById(R.id.templatePrice);
        TextView ticketType = v.findViewById(R.id.templateTicketType);
        TextView date = v.findViewById(R.id.templateDate);

        AirlineTicket ticket = tickets.get(i);
        passengerName.setText(ticket.getPassengerName());
        price.setText(ticket.getPrice().toString());
        ticketType.setText(ticket.getTypeOfFlight());
        date.setText(ticket.getDateOfFlight().toString());
        return v;
    }
}
