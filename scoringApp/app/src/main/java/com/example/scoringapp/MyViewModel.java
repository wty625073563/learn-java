package com.example.scoringapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> aTeamScore;
    private MutableLiveData<Integer> bTeamScore;

    // 用于记录添加的得分，方便后续撤回
    private ArrayList<Integer> socreList = new ArrayList<>();
    // 记录战队得分顺序
    private String aTeamName = "张政战队";
    private String bTeamName = "刘佳战队";
    private ArrayList<String> teamSocreList = new ArrayList<>();

    /**
     * 获取张政战队的分数
     * @return
     */
    public MutableLiveData<Integer> getaTeamScore() {
        if (aTeamScore == null) {
            aTeamScore = new MutableLiveData<>();
            aTeamScore.setValue(0);
        }
        return aTeamScore;
    }

    /**
     * 获取刘佳战队的分数
     * @return
     */
    public MutableLiveData<Integer> getbTeamScore() {
        if (bTeamScore == null) {
            bTeamScore = new MutableLiveData<>();
            bTeamScore.setValue(0);
        }
        return bTeamScore;
    }

    /**
     * 张政战队加分
     * @param p
     */
    public void addATeamScore(int p) {
        socreList.add(p);
        teamSocreList.add(aTeamName);
        aTeamScore.setValue(aTeamScore.getValue() + p);
    }

    /**
     * 刘佳战队加分
     * @param p
     */
    public void addBTeamScore(int p) {
        socreList.add(p);
        teamSocreList.add(bTeamName);
        bTeamScore.setValue(bTeamScore.getValue() + p);
    }

    /**
     * 撤回加分
     */
    public void withdrawScore() {

        // last
        int lastTs = teamSocreList.size() - 1;
        int lastSs = socreList.size() - 1;

        // 防止乱撤回
        if (lastTs < 0 || lastSs < 0) return;

        // 获取last加分的战队
        String teamName = teamSocreList.get(lastTs);
        int lastS = socreList.get(lastSs);

        // 判断减去哪一队的得分
        if (teamName == aTeamName) {
            aTeamScore.setValue(aTeamScore.getValue() - lastS);
        } else {
            bTeamScore.setValue(bTeamScore.getValue() - lastS);
        }

        System.out.println(lastTs);
        // 消除记录
        teamSocreList.remove(lastTs);
        socreList.remove(lastSs);
    }

    /**
     * 重置分数
     */
    public void resetScore() {
        // 清空记录
        socreList.clear();
        aTeamScore.setValue(0);
        bTeamScore.setValue(0);
    }
}
