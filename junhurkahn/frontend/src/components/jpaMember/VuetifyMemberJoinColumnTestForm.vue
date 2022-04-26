 <template>

  <v-container>

      <form action="index.html" method="post" @submit.prevent="onSubmit">
            <div class="box">
     
     
      <h3>회원 가입 양식</h3>

      <div class="row">
        
        <v-radio-group v-model="radioGroup" row>
            
          <!-- 기존에 사용하던 형식의 문법이 마겨서 아래와 같이 작업해야함
               다소 번거로움이 추가됨 -->
         
        </v-radio-group>
      </div>

      <table>
        <tr>
         <input class="username" name="username" type="text" v-model="id" placeholder="User Name" >
        </tr>
        <tr>
         <input class="username" name="username" type="password" v-model="pw" placeholder="Password">
        </tr>
      </table>

      <div>
         <button class="teal" type="submit">등록</button>
        <router-link :to="{ name: 'Home' }">
          취소 
        </router-link>
      </div>
            </div>
    </form>
           
     
    
  </v-container>


</template>

<script>

export default {
  name: "VuetifyMemberRegisterForm.vue",
  data () {
    return {
      radioGroup: 1,
      kindsOfMember: [
        '개인',
        '사업자'
      ],
      id: '',
      pw: ''
    }
  },
  methods: {
    onSubmit () {
      const { id, pw, radioGroup } = this
      const auth = (radioGroup == '개인' ? '개인' : '사업자')
      this.$emit('submit', { id, pw, auth })
       
    }
  }
}

</script>

<style scoped>


        #absoluteCenteredDiv{
            position: absolute;
            top:0;
            bottom: 0;
            left: 0;
            right: 0;
            margin: auto;
            width:400px;
            height: 300px;
            text-align: center;
       }

        .fpwd{
            color:#f1c40f;
            text-decoration: underline;
        }

          p{
          font-size:12px;
          text-decoration: none;
          color:#ffffff;
        }

           h1{
          font-size:1.5em;
          color:#525252;
        }

        .username{
          background:#ecf0f1;
          border: #ccc 1px solid;
          border-bottom: #ccc 2px solid;
          padding: 8px;
          width:250px;
          color:#AAAAAA;
          margin-top:10px;
          font-size:1em;
          border-radius:4px;
        }



</style>