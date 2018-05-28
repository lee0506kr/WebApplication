package model;

public class Loan {
	// ȸ���� ���� ��ȯ ������ ������ �� �ִ� Ŭ����
	// ��ȯ�� : repayTotal : �� ��ȯ���� + �� ����
	// ��ȯ����: repayOrigin : �� ��ȯ����
	// ���� : interest
	// ��ȯ�Ѿ� : repaySum : ��ȯ ��������
	// �����ܾ� : repayRemain : ���� - ��ȯ���� �Ѿ�

	
	private int repayTotal;
	private int repayOrigin;
	private int interest;
	private int repaySum;
	private int repayRemain;


	public int getRepayTotal() {
		return repayTotal;
	}

	public void setRepayTotal(int repayTotal) {
		this.repayTotal = repayTotal;
	}

	public int getRepayOrigin() {
		return repayOrigin;
	}

	public void setRepayOrigin(int repayOrigin) {
		this.repayOrigin = repayOrigin;
	}

	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {

		this.interest = interest;
	}

	public int getRepaySum() {
		return repaySum;
	}

	public void setRepaySum(int repaySum) {
		this.repaySum = repaySum;
	}

	public int getRepayRemain() {
		return repayRemain;
	}

	public void setRepayRemain(int repayRemain) {
		this.repayRemain = repayRemain;
	}

	

	public Loan(int repayTotal, int repayOrigin, int interest, int repaySum, int repayRemain) {

		this.repayTotal = repayTotal;
		this.repayOrigin = repayOrigin;
		this.interest = interest;
		this.repaySum = repaySum;
		this.repayRemain = repayRemain;

	}

}
