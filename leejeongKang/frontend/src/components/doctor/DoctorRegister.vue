<template>
    <body>
      <v-container>
      <form @submit.prevent="onSubmit">
        <h2>의사 등록</h2>
        <v-text-field v-model="major" label="진료과" type="text"></v-text-field>
          <v-text-field v-model="doctorName" label="이름" type="text"></v-text-field>
          <v-textarea v-model="information" label="소개" type="text" height="300px" ></v-textarea>
          <div id ='btn'>
            <v-btn type="submit">등록</v-btn>
            <v-btn @click="changeColor">버튼</v-btn>
          </div>
      </form>
  </v-container>
</body>
</template>

<script>
export default {
  name: 'DoctorRegister',
  data () {
    return {
      major: '',
      doctorName: '',
      information: ''
    }
  },
  methods: {
    onSubmit () {
      const { major, doctorName, information } = this
      this.$emit('submit', { major, doctorName, information })
    },
    changeColor () {

    }
  }
}
</script>

<style scoped>
#btn { text-align: center; font-size: 20px; }
#BtnRegister { background-color: navy; width: 500px; height: 55px;}
#changeColor { background-color: red; }
</style>
