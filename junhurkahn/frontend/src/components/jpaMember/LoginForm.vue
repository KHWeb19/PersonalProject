<template>

  <v-container>
    
      
        <form  @submit.prevent="onSubmit" action="index.html" method="post" >
            <div class="box">
     
      <h3>로그인 형식</h3>
      <table>
        <tr>
        
          <input class="username" v-model="id" name="username" type="text" placeholder="User Name" >
        </tr>
        
        <tr>
       
           <input class="username"   v-model="pw" name="username" type="password" placeholder="Password">
        </tr>
      </table>

      <div>
        <button class="teal" type="submit">로그인</button>
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
  name: "LoginForm.vue",
  data () {
    return {
      id: '',
      pw: ''
    }
  },
  methods: {
    onSubmit () {
      const { id, pw } = this
      this.$emit('submit', { id, pw })
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