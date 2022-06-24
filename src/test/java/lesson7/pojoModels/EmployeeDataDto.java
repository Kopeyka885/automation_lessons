package lesson7.pojoModels;

public class EmployeeDataDto {
    private int departmentId;
    private int directorId;
    private String email;
    private String firstName;
    private int hrId;
    private boolean isTrainee;
    private String lastName;
    private String patronymic;
    private String phoneNumber;
    private int positionId;
    private String startDate;

    @Override
    public String toString() {
        return "EmployeeDataDto{" +
                "departmentId=" + departmentId +
                ", directorId=" + directorId +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", hrId=" + hrId +
                ", isTrainee=" + isTrainee +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", positionId=" + positionId +
                ", startDate='" + startDate + '\'' +
                ", teamId=" + teamId +
                ", telegram='" + telegram + '\'' +
                ", toShowPatronymic=" + toShowPatronymic +
                ", workStatus='" + workStatus + '\'' +
                '}';
    }

    private int teamId;
    private String telegram;
    private boolean toShowPatronymic;
    private String workStatus;

    public EmployeeDataDto(int departmentId, int directorId, String email, String firstName, int hrId,
                           boolean isTrainee, String lastName, String patronymic, String phoneNumber, int positionId,
                           String startDate, int teamId, String telegram, boolean toShowPatronymic, String workStatus) {
        this.departmentId = departmentId;
        this.directorId = directorId;
        this.email = email;
        this.firstName = firstName;
        this.hrId = hrId;
        this.isTrainee = isTrainee;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.positionId = positionId;
        this.startDate = startDate;
        this.teamId = teamId;
        this.telegram = telegram;
        this.toShowPatronymic = toShowPatronymic;
        this.workStatus = workStatus;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getHrId() {
        return hrId;
    }

    public void setHrId(int hrId) {
        this.hrId = hrId;
    }

    public boolean getIsTrainee() {
        return isTrainee;
    }

    public void setIsTrainee(boolean trainee) {
        isTrainee = trainee;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    public boolean isToShowPatronymic() {
        return toShowPatronymic;
    }

    public void setToShowPatronymic(boolean toShowPatronymic) {
        this.toShowPatronymic = toShowPatronymic;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }
}
