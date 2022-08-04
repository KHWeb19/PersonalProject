<template>
  <body>
   <v-container>
    <form id="contents">
      <h2>의사 정보</h2><br><br><br>
      <div id="top">
      <div class="right">
      <v-text-field :value="doctor.major" label="진료과" type="text" readonly></v-text-field>
      <v-text-field :value="doctor.doctorName" label="이름" type="text" readonly></v-text-field>
      <v-textarea :value="doctor.information" label="소개" type="text" height="300px" readonly></v-textarea>
      </div>
      </div>
    </form>
   </v-container>
  </body>
</template>

<script>
export default {
  name: 'DoctorRead',
  props: {
    doctor: {
      type: Object,
      required: true
    }
  }
}
</script>

<style scoped>
h2 { font-size: 30px;}
.top { width: 100%; height: 500px;}
.left { width: 50%; float: left; }
.bottom { width: 100% }
#contents { text-align: center; }
#btn { text-align: center; font-size: 20px; }
#BtnAppoint { background-color: navy; width: 500px; height: 55px;}
</style>
