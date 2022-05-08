<template>
    <v-container style="text-align: center; width: 350px; height: 382px; margin-top: 120px;">
            <v-flex>
                <v-card>
                    <form @submit.prevent="onSubmit"  >
                        <img style="margin: 40px 0px 18px 0px;" src="@/assets/vuelogo.png"/>
                        <h4>로그인에 문제가 있나요?</h4>
                        <div style="color: grey; font-size: 14px">아이디와 회원가입 시 입력한 비밀번호 힌트로<br/>계정의 비밀번호를 변경 할 수 있습니다.</div>
                        <br/>
                        <div>
                            <input style="background-color: #fafafa; 
                                margin: 3px;
                                border: 1px solid #d6d6d6; 
                                border-radius: 3px; 
                                width: 268px; 
                                height: 38px;
                                padding-left: 5px;" 
                            type="text" placeholder="아이디" v-model="memberId"/>
                        </div>
                        <div>
                            <input style="background-color: #fafafa; 
                                margin: 3px;
                                border: 1px solid #d6d6d6; 
                                border-radius: 3px; 
                                width: 268px; 
                                height: 38px;
                                padding-left: 5px;" 
                            type="text" placeholder="비밀번호 힌트" v-model="passwordHint"/>
                        </div>
                        <div>
                            <v-btn style="margin: 10px; width: 268px; height: 30px;" color="blue" class="white--text" type="submit">비밀번호 변경</v-btn>
                        </div>
                    </form>
                    
                    <br/>
                    <span style="color: grey; font-size: 14px">또는</span>
                    <div>
                        <router-link style="text-decoration: none;" :to="{name: 'RegisterPage'}">
                            <button class="black--text">&nbsp;새 계정 만들기</button>
                        </router-link>
                    </div>
                    <br/>
                </v-card>
                <br/>
                <v-card style="width: 350px; height: 63px; display: table-cell; vertical-align: middle;">
                    <div>
                        <router-link style="text-decoration: none;" :to="{name: 'LoginPage'}">
                            <button class="black--text">로그인으로 돌아가기</button>
                        </router-link>
                    </div>
                </v-card>
            </v-flex>

        </v-container>
</template>

<script>
export default {
    name: "ForgetPasswordForm",
    data() {
        return {
            memberId: '',
            passwordHint: ''
        }
    },
    methods: {
        onSubmit() {
            const {memberId, passwordHint} = this
            this.$emit('submit', {memberId, passwordHint})
        }
    }
}
</script>