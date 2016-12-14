package com.sangupta.keepwalking;

/**
 * Created by vova2 on 9.12.2016.
 */
public class Record {
    private int _id;
    private double _amount;
    private String _name;
    private String _time;
    private int _group;
    private String userid;
    private boolean paid;
    private int sequenceid;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public double get_amount() {
        return _amount;
    }

    public void set_amount(double _amount) {
        this._amount = _amount;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_time() {
        return _time;
    }

    public void set_time(String _time) {
        this._time = _time;
    }

    public int get_group() {
        return _group;
    }

    public void set_group(int _group) {
        this._group = _group;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public int getSequenceid() {
        return sequenceid;
    }

    public void setSequenceid(int sequenceid) {
        this.sequenceid = sequenceid;
    }
}
