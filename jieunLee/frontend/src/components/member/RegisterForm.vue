<template>
    <v-container style="text-align: center; width: 350px; height: 382px; margin-top: 70px;">
            <v-flex>
                <v-card>
                    <form @submit.prevent="onSubmit"  >
                        <img style="margin: 40px 0px 18px 0px;" src="@/assets/vuelogo.png"/>
                        <h3 style="color: grey">친구들의 사진과 동영상을 보려면<br/>가입하세요.</h3>
                        <br/>
                        
                        <div>
                            <input style="background-color: #fafafa; 
                                margin: 3px;
                                border: 1px solid #d6d6d6; 
                                border-radius: 3px; 
                                width: 268px; 
                                height: 38px;
                                padding-left: 5px;" 
                            type="text" placeholder="성명" v-model="memberName"/>
                        </div>
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
                            type="password" placeholder="비밀번호" v-model="password"/>
                        </div>
                        <div><v-btn style="margin: 10px; width: 268px; height: 30px;" color="blue" class="white--text" type="submit">가입</v-btn></div>
                    </form>
                    <br/>
                </v-card>
                <br/>
                <v-card style="width: 350px; height: 63px; display: table-cell; vertical-align: middle;">
                    <div>
                        계정이 있으신가요?
                        <router-link style="text-decoration: none;" :to="{name: 'LoginPage'}">
                        <button class="blue--text" type="button">&nbsp;로그인</button>
                        </router-link>
                    </div>
                </v-card>
            </v-flex>

        </v-container>
</template>

<script>
export default {
    data () {
    return {
      memberId: '',
      password: ''
    }
  },
  methods: {
    onSubmit () {
      const { memberName, memberId, password } = this
      this.$emit('submit', { memberName, memberId, password })
    }
  }
}
</script>