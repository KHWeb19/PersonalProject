<template>
    <div>
        <v-container style="max-width: 1000px; margin-top: 85px;">
        <v-flex>
            <div style="display: flex; justify-content: center;">

                <div style="border-radius: 70%; overflow: hidden;  margin-right: 45px;">
                    <v-img v-if="member.imageName" width="150px" height="150px" :src="require(`@/assets/mImage/${member.imageName}`)"/>
                    <v-img v-else width="150px" height="150px" src="@/assets/profile.jpg"/>
                </div>

                <div style="width: 620px;  padding-left: 50px;">
                    <div style="display: flex;">
                        <div style="font-size: 28px;">{{member.memberId}}</div> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <router-link style="text-decoration: none;" :to="{
                            name: 'AccountsEditPage',
                            params: {memberNo: member.memberNo.toString()}}">
                            <v-btn v-if="member.memberNo==loginInfo.memberNo" style="margin: 4px 0px 0px 10px;" color="white">프로필 편집</v-btn>
                        </router-link>
                        <v-btn v-if="member.memberNo!=loginInfo.memberNo" style="margin-top: 4px" depressed color="primary" @click="onFollow(member.memberNo)"><b>팔로우</b></v-btn>
                    </div>
                    <br/>
                    <div style="padding-bottom: 20px;">
                        게시물 <b style="padding-right: 30px">{{myBoards.length}}</b>
                        <v-dialog persisten max-width="400">
                            <template v-slot:activator="{ on }">
                                <span v-on="on" style="cursor:pointer">팔로워 <b style="padding-right: 30px">{{member.followers.length}}</b></span>
                            </template>
                            <template v-slot:default="dialog">
                                <v-card>
                                    <v-card-title class="headline">
                                        팔로워
                                    </v-card-title>
                                    <v-card-text>
                                        <v-row>
                                            <v-col style="height: 320px; text-align: center;" v-if="!member.followers || (Array.isArray(member.followers) && member.followers.length === 0)">
                                            팔로우한 회원이 없습니다!
                                            </v-col>
                                            <v-col style="height: 320px;" v-else v-for="follow in member.followers" :key="follow.no"  cols="4">
                                                    <div style="display: flex; padding: 3px 0px">
                                                        <div>
                                                            <td style="padding-top: 1px">
                                                                <div style="border-radius: 70%; overflow: hidden; width: 33px ">
                                                                    <v-img v-if="follow.my.imageName" width="33" :src="require(`@/assets/mImage/${myFollow.my.imageName}`)"/>
                                                                    <v-img v-else width="33" src="@/assets/profile.jpg"/>
                                                                </div>
                                                            </td>
                                                        </div>
                                                        <div>
                                                            <td align="left" >
                                                                <v-btn text @click="goProfile(follow.my.memberNo)">
                                                                    <div>
                                                                        <b>{{ follow.my.memberId }}</b>
                                                                        <div style="color: gray">{{ follow.my.memberName }}</div>
                                                                    </div>
                                                                </v-btn>
                                                            </td>
                                                        </div>
                                                    </div>

                                                <!-- </router-link> -->
                                            </v-col>
                                        </v-row>
                                    </v-card-text>
                                    <v-card-actions>
                                        <v-spacer></v-spacer>
                                        <v-btn text @click="dialog.value=false">
                                            닫기
                                        </v-btn>
                                    </v-card-actions>
                                </v-card>
                            </template>
                        </v-dialog>
                        <v-dialog persisten max-width="400">
                            <template v-slot:activator="{ on }">
                                <span v-on="on" style="cursor:pointer">팔로우 <b>{{member.followings.length}}</b></span>
                            </template>
                            <template v-slot:default="dialog">
                                <v-card>
                                    <v-card-title class="headline">
                                        팔로우
                                    </v-card-title>
                                    <v-card-text>
                                        <v-row>
                                            <v-col style="height: 320px; text-align: center;" v-if="!member.followings || (Array.isArray(member.followings) && member.followings.length === 0)">
                                            팔로우한 회원이 없습니다!
                                            </v-col>
                                            <v-col style="height: 320px;" v-else v-for="follow in member.followings" :key="follow.no"  cols="4">
                                                    <div style="display: flex; padding: 3px 0px">
                                                        <div>
                                                            <td style="padding-top: 1px">
                                                                <div style="border-radius: 70%; overflow: hidden; width: 33px ">
                                                                    <v-img v-if="follow.your.imageName" width="33" :src="require(`@/assets/mImage/${myFollow.your.imageName}`)"/>
                                                                    <v-img v-else width="33" src="@/assets/profile.jpg"/>
                                                                </div>
                                                            </td>
                                                        </div>
                                                        <div>
                                                            <td align="left" >
                                                                <v-btn text @click="goProfile(follow.your.memberNo)">
                                                                    <div>
                                                                        <b>{{ follow.your.memberId }}</b>
                                                                        <div style="color: gray">{{ follow.your.memberName }}</div>
                                                                    </div>
                                                                </v-btn>
                                                            </td>
                                                        </div>
                                                    </div>

                                                <!-- </router-link> -->
                                            </v-col>
                                        </v-row>
                                    </v-card-text>
                                    <v-card-actions>
                                        <v-spacer></v-spacer>
                                        <v-btn text @click="dialog.value=false">
                                            닫기
                                        </v-btn>
                                    </v-card-actions>
                                </v-card>
                            </template>
                        </v-dialog>
                    </div>
                    <b>{{member.memberName}}</b>
                    <div v-if="member.memberWeb">
                        {{member.memberWeb}} 
                        <br/>
                        {{member.memberIntro}} 
                    </div>
                    <div v-else>
                        {{member.memberIntro}} 
                    </div>

                </div>
            </div>
            <br/>
            <br/>
            
        </v-flex>
        </v-container>
    </div>    
</template>

<script>
import axios from 'axios'
export default {
    name: 'MyProfile',
    props: {
        member: {
            type: Object,
            require:true
      },
        myBoards: {
            type: Array
        }
    },
    data() {
        return {
            loginInfo: JSON.parse(localStorage.getItem('loginInfo'))
        }
    },
    methods: {
        goProfile(memberNo) {
            this.$router.push(`/${memberNo}`)
            history.go(0);
        },
        onFollow(memberNo) {
            axios.post(`http://localhost:7777/follow/${this.loginInfo.memberNo}/${memberNo}`, {loginNo: this.loginInfo.memberNo, memberNo})
                .then(() => {
                    history.go(0);
                })
                .catch(() => {
                    alert('문제 발생!')
                })
        }
    }
}
</script>

