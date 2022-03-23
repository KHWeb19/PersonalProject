<template>
    <div>
        <v-container style="width: 350px; margin-top: 80px;">
            
                <v-flex>
                    
                    <v-card style="height: 382px;">
                    <form @submit.prevent="onSubmit"  >
                        <br/>
                        <h1 style="margin: 10px;">Vuestagram</h1>
                        <br/>
                        <div>
                            <input style="background-color: #fafafa; 
                                margin: 3px;
                                border: 1px solid #d6d6d6; 
                                border-radius: 3px; 
                                width: 268px; 
                                height: 38px;" 
                            type="text" placeholder="아이디" v-model="writer"/>
                        </div>
                        <div>
                            <input style="background-color: #fafafa; 
                                margin: 3px;
                                border: 1px solid #d6d6d6; 
                                border-radius: 3px; 
                                width: 268px; 
                                height: 38px;" 
                            type="text" placeholder="비밀번호" v-model="writer"/>
                        </div>
                        <div><v-btn style="margin: 10px; width: 268px; height: 30px;" color="blue" class="white--text" type="submit">로그인</v-btn></div>
                    </form>
                    <div><button style="margin: 50px;" class="indigo--text" type="button">비밀번호를 잊으셨나요?</button></div>
                    </v-card>
                </v-flex>

                <br/>

                <v-flex>
                <v-card style="width: 350px; height: 63px; display: table-cell; vertical-align: middle;">
                    <div>
                        계정이 없으신가요?
                        <router-link style="text-decoration: none;" :to="{name: 'RegisterPage'}">
                        <button class="blue--text" type="button">&nbsp;가입하기</button>
                        </router-link>
                    </div>
                </v-card>
                </v-flex>

            
        </v-container>
    </div>        
</template>

<script>
export default {
    setup() {
        
    },
}
</script>

<style>
#app {
  text-align: center;
}

.v-main {
    background-color: #fafafa;

}

</style>
