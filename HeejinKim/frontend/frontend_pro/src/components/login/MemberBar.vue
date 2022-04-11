<template>
      <div>
        <v-menu offset-y>
            <template v-slot:activator="{ on, attrs }">
                <v-btn  text v-bind="attrs" v-on="on">
                {{ session.userId }} 님
                </v-btn>
            </template>

            <v-list class="memberBtn">
                <v-list-item>
                    <v-list-item-title @click="memberInfo" class="text-center" >My</v-list-item-title>
                </v-list-item>

                <v-divider></v-divider>

                <v-list-item>
                    <v-list-item-title @click="logoutBtn"> Sign Out</v-list-item-title>
                </v-list-item>
           </v-list>
        </v-menu>
      </div>
</template>

<script>
export default {
  name: "MemberBar",
  props: {
    session: {
      type: Object,
      required: true
    },
  },
  methods: {
    logoutBtn () {
      this.$emit('logout')
    },
    memberInfo() {
      this.$router.push({ name: 'MemberInfoPage' })
    }
  }
}
</script>

<style scoped>
.memberBtn{
  cursor: pointer;
  
}

</style>